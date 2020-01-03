package test;

import learn2.Sort;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author： Administrator
 * @create： 2020-01-02 15:13
 * 说明： 测试
 */
public class TestSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 6, 8, 7, 0, 1, 10, 4, 2};
        Sort sort = new Sort();

//        System.out.println("排序之前：" + Arrays.toString(arr));
//        sort.bubbleSort(arr);
//        System.out.println("排序之后：" + Arrays.toString(arr));


//        System.out.println("排序之前：" + Arrays.toString(arr));
//        sort.quickSort(arr,0,arr.length-1);
//        System.out.println("排序之后：" + Arrays.toString(arr));
        //开始位置是最后一个非叶子节点，即最后一个节点的父节点
        sort.heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
