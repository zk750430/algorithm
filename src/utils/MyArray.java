package utils;

import java.util.Arrays;

/**
 * @author Administrator
 */
public class MyArray {
    /**
     * 用于存储数据的数组
     */
    private int[] elements;

    public MyArray() {
        elements = new int[0];
    }

    /**
     * 获取数组长度的方法
     */

    public int size() {
        return elements.length;
    }

    /**
     * 往数组的末尾添加元素
     */
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

    /**
     * 往数组的指定位置添加元素
     */
    public void insert(int index, int element) {
        if (index < 0 || index > elements.length) {
            throw new RuntimeException("数组下标越界");
        }
        int[] newArr = new int[elements.length + 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else if (i == index) {
                newArr[i] = element;
            } else {
                newArr[i] = elements[i - 1];
            }
        }
        elements = newArr;
    }

    /**
     * 删除元素
     */
    public void delete() {
        isEmpty();
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 指定下标
     */
    public void delete(int index) {
        checkIndex(index);
        int[] newArr = new int[elements.length - 1];
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) {
                newArr[i] = elements[i];
            } else {
                newArr[i] = elements[i + 1];
            }
        }
        elements = newArr;
    }

    /**
     * 替换指定位置的元素
     *
     * @param index   指定位置
     * @param element 新元素
     */
    public void replace(int index, int element) {
        checkIndex(index);
        elements[index] = element;
    }

    /**
     * 查询指定位置的数据
     *
     * @param index 下标
     */
    public int get(int index) {
        checkIndex(index);
        return elements[index];
    }


    /**
     * 检查数组下标是否越界
     *
     * @param index 下标
     */
    public void checkIndex(int index) {
        if (index < 0 || index > elements.length - 1) {
            throw new RuntimeException("数组下标越界");
        }
    }


    /**
     * 打印所有元素到控制台
     */
    public void show() {
        System.out.println(Arrays.toString(elements));
    }

    public void isEmpty() {
        if (elements.length == 0) {
            throw new RuntimeException("数组为空");
        }
    }

    /**
     * 普通元素的下标位置
     *
     * @param target 指定元素
     * @param arr    数组
     * @return 1代表没有，
     */
    public int search(int target, int[] arr) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                index = i;
                break;
            }
        }
        return index;
    }


    /**
     * 顺序数组采用二分法查找
     *
     * @param target 指定元素
     * @param arr    数组
     * @return -1代表没有此元素
     */
    public int binarySearch(int target, int[] arr) {
        int begin = 0;
        int end = arr.length - 1;
        int middle = (begin + end) / 2;
        while (true) {
            //什么情况下没有这个元素
            //开始位置在结束位置之后或重合
            if (begin >= end) {
                return -1;
            }
            if (arr[middle] == target) {
                return middle;
            } else {
                if (arr[middle] > target) {
                    end = middle - 1;
                } else {
                    begin = middle + 1;
                }
                middle = (begin + end) / 2;
            }
        }
    }

}
