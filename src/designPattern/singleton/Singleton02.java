package designPattern.singleton;

/**
 * @author： Administrator
 * @create： 2020-05-14 10:34
 * 说明：懒汉式，按需初始化，会带来线程不安全的问题,可通过加锁方式
 */
public class Singleton02 {

    public volatile static Singleton02 INSTANCE = null;

    private Singleton02() {
    }

    public static Singleton02 getINSTANCE() {
        if (INSTANCE == null) {
            synchronized (Singleton02.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton02();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Singleton02.getINSTANCE().hashCode());
            }).start();
        }
    }
}
