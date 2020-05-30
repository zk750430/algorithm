package designPattern.staticFactory;

import designPattern.factoryMethod.Moveable;

/**
 * @author: zk
 * @create: 2020-05-18 22:05
 */
public class Car extends Vehicle{
    @Override
    public void go() {
        System.out.println("Car---------开动啦");
    }
}
