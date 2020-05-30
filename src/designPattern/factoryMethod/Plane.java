package designPattern.factoryMethod;

/**
 * @author: zk
 * @create: 2020-05-18 22:05
 */
public class Plane implements Moveable{
    @Override
    public void go() {
        System.out.println("plane------开动了！");
    }
}
