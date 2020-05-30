package designPattern.staticFactory;

/**
 * @author: zk
 * @create: 2020-05-18 23:05
 */
public abstract class AbstrcactFactory {
    public abstract Food createFood();

    public abstract Weapon createWeapon();

    public abstract Vehicle createVehicle();
}
