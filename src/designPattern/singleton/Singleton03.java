package designPattern.singleton;

/**
 * @author： Administrator
 * @create： 2020-05-14 10:59
 * 说明：静态内部类方式，JVM保证单例，加载外部类时不会加载内部类，这样就可以实现懒加载
 */
public class Singleton03 {
    private Singleton03() {
    }

    private static class Singleton03Holder {
        private static final Singleton03 INSTANCE = new Singleton03();
    }

    public static Singleton03 getInstance() {
        return Singleton03Holder.INSTANCE;
    }
}
