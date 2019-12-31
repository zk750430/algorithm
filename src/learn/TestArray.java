package learn;

public class TestArray {
    public static void main(String[] args) {
        // 创建一个数组
        int[] arr1 = new int[3];
        //获取数组的长度
        int length1 = arr1.length;
        System.out.println("arr1's length：" + length1);
        // 访问数组中的元素:数组名[下标]   注意：下标从0开始，最大可以取到长度-1
        int element0 = arr1[0];
        System.out.println("element0：" + element0);
        // 为数组中的元素赋值
        arr1[0] = 99;
        System.out.println("element0：" + arr1[0]);
        arr1[1] = 98;
        arr1[2] = 97;
        //遍历数组
        //1
        for (int i : arr1) {
            System.out.println("arr1 element：" + i);
        }
        //2
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("arr1 element" + i + "：" + arr1[i]);

        }

        // 创建数组的同时，为数组中的元素赋值
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        System.out.println("arr2's length：" + arr2.length);
    }
}
