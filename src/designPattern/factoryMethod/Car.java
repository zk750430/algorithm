package designPattern.factoryMethod;

/**
 * @author: zk
 * @create: 2020-05-18 22:05
 */
public class Car implements Moveable{
    @Override
    public void go() {
        System.out.println("Car---------开动啦");
    }
}
