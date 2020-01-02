package test;

import utils.MyArray;

/**
 * @author Administrator
 */
public class TestMyArray {
    public static void main(String[] args) {
        MyArray my = new MyArray();
        System.out.println(my.size());
        my.add(88);
        my.show();
        my.add(77);
        my.insert(2,99);
        my.show();
        System.out.println(my.get(1));
        my.delete();
        my.show();
        my.delete(0);
        my.show();
        my.add(1);
        my.add(2);
        my.add(3);
        my.replace(0, 10);
        my.show();
    }
}
