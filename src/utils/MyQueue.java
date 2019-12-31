package utils;

import java.util.Arrays;

public class MyQueue {

    int[] elements;

    public MyQueue() {
        elements = new int[0];
    }

    //入队
    public void add(int element) {
        //创建一个新的数组
        int[] newArr = new int[elements.length + 1];
        //把原数组中的元素复制到新数组中
        for (int i = 0; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        newArr[elements.length] = element;
        elements = newArr;
    }

    //出队
    public int poll(){
        isEmpty();
        int element = elements[0];
        //创建一个新的数组
        int[] newArr = new int[elements.length-1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i+1];
        }
        elements = newArr;
        return element;
    }
    public void isEmpty() {
        if (elements.length == 0) {
            throw new RuntimeException("数组为空");
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(elements);
    }
}
