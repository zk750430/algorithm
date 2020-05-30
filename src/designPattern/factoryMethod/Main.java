package designPattern.factoryMethod;

/**
 * @author: zk
 * @create: 2020-05-18 22:05
 */
public class Main {
    public static void main(String[] args) {
        Moveable moveable = new Plane();
        moveable.go();
    }
}
