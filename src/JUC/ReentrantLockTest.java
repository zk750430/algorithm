package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author： Administrator
 * @create： 2020-05-28 9:18
 * 说明：多线程之间顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 * A打印5次，B打印10次，C打印15次
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ShareData shareData = new ShareData();
        new Thread(() -> {
            shareData.TestA();
        }, "A").start();
        new Thread(() -> {
            shareData.TestB();
        }, "B").start();
        new Thread(() -> {
            shareData.TestC();
        }, "C").start();
    }

}

class ShareData {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    private int num = 1;

    public void TestA() {
        lock.lock();
        try {
            while (num != 1) {
                condition1.await();
            }
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() + '\t' + i);
            }
            num = 2;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void TestB() {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + '\t' + i);
            }
            num = 3;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void TestC() {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() + '\t' + i);
            }
            num = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
