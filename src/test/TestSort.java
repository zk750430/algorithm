package test;

import learn2.Sort;

import java.util.Arrays;

/**
 * @author： Administrator
 * @create： 2020-01-02 15:13
 * 说明： 测试
 */
public class TestSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, 4, 3, 5, 2, 6, 7, 2, 0, 7, 10, 49};
        Sort sort = new Sort();

//        System.out.println("排序之前：" + Arrays.toString(arr));
//        sort.bubbleSort(arr);
//        System.out.println("排序之后：" + Arrays.toString(arr));


//        System.out.println("排序之前：" + Arrays.toString(arr));
//        sort.quickSort(arr,0,arr.length-1);
//        System.out.println("排序之后：" + Arrays.toString(arr));

        sort.mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
