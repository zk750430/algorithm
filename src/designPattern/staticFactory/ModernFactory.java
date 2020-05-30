package designPattern.staticFactory;

/**
 * @author: zk
 * @create: 2020-05-18 23:05
 */
public class ModernFactory extends AbstrcactFactory{

    @Override
    public Food createFood() {
        return new Bread();
    }

    @Override
    public Weapon createWeapon() {
        return new AK47();
    }

    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}
