package learn;

import java.util.Arrays;

/**
 * 添加数组元素
 * @author Administrator
 */
public class TestOpArray {
    public static void main(String[] args) {
        //解决数组的长度不可变得问题
        int[] arr = new int[]{9, 8, 7};
        //快速查看数组中的元素
        System.out.println(Arrays.toString(arr));
        //要加入数组的目标元素
        int dst = 6;

        //创建一个新数组，长度为原来数组的长度+1
        int[] arr1 = new int[arr.length+1];
        //把原本的数组中的数据全部复制到新数组中
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }

        //把目标元素放入新数组的最后
        arr1[arr.length] = dst;

        //新数组替换旧数组
        arr = arr1;
        System.out.println(Arrays.toString(arr));

    }
}
