package designPattern.staticFactory;

/**
 * @author: zk
 * @create: 2020-05-18 23:05
 */
public class MagicFactory extends AbstrcactFactory {
    @Override
    public Food createFood() {
        return new MagicBread();
    }

    @Override
    public Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    public Vehicle createVehicle() {
        return new MagicRoom();
    }
}
