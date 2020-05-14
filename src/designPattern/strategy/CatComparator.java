package designPattern.strategy;

import java.util.Comparator;

/**
 * @author： Administrator
 * @create： 2020-05-14 17:16
 * 说明：猫的比较器
 */
public class CatComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        if (o1.weight > o2.weight) {
            return -1;
        } else if (o1.weight > o2.weight) {
            return 1;
        } else {
            return 0;
        }
    }
}
