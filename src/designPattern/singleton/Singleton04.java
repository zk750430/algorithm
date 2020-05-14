package designPattern.singleton;

/**
 * 不仅解决线程同步，还可以防止反序列化,枚举类没有构造方法，所以能防止反序列化
 * @author zk
 */
public enum Singleton04 {
    INSTANCE;

    public Singleton04 getInstance() {
        return INSTANCE;
    }
}
