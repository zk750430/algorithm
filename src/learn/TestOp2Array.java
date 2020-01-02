package learn;

import java.util.Arrays;

/**
 * 删除指定位置的元素
 * @author Administrator
 */
public class TestOp2Array {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4};
        System.out.println(Arrays.toString(arr));
        int index = 3;
        int[] arr1 = new int[arr.length - 1];
        for (int i = 0; i < arr1.length; i++) {
            if (i < index) {
                arr1[i] = arr[i];
            } else {
                arr1[i] = arr[i + 1];
            }
        }
        // 新旧数组替换
        arr = arr1;
        System.out.println(Arrays.toString(arr));
    }
}
