package designPattern.singleton;

/**
 * @author： Administrator
 * @create： 2020-05-14 10:29
 * 说明：饿汉式
 *   缺点：不管用到与否，在类装载时就完成实例化
 */
public class Singleton01 {
    private static final Singleton01 INSTANCE = new Singleton01();

    private Singleton01(){};

    public static Singleton01 getINSTANCE() {
        return INSTANCE;
    }
}
