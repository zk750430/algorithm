package designPattern.factoryMethod;


/**
 * @author: zk
 * @create: 2020-05-18 22:05
 */
public class SimpleVehicleFactory {
    public Moveable createCat(){
        return new Car();
    }
    public Moveable createPlane(){
        return new Plane();
    }
}
