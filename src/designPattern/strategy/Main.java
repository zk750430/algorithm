package designPattern.strategy;

import java.util.Arrays;

/**
 * @author： Administrator
 * @create： 2020-05-14 15:06
 * 说明：主测试
 */
public class Main {
    public static void main(String[] args) {
        Cat[] cat = {new Cat(2, 3), new Cat(3, 3), new Cat(4, 3)};
        Sorter<Cat> sorter = new Sorter<>();
        sorter.sort(cat,new CatComparator());
        System.out.println(Arrays.toString(cat));
    }
}
