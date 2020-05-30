package designPattern.staticFactory;


/**
 * @author: zk
 * @create: 2020-05-18 22:05
 */
public class Main {
    public static void main(String[] args) {
        AbstrcactFactory f = new ModernFactory();
        Food food = f.createFood();
        food.printName();
        Weapon w = f.createWeapon();
        w.shoot();
        Vehicle v = f.createVehicle();
        v.go();
    }
}
