package JUC;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author： Administrator
 * @create： 2020-05-28 10:20
 * 说明：Callable案例
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        new Thread(futureTask,"A").start();
//        Integer result  = futureTask.get();
//        System.out.println(result);

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("come in call method()");
        return 1204;
    }
}