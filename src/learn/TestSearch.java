package learn;

import java.net.BindException;

/**
 * @author Administrator
 */
public class TestSearch {
    public static void main(String[] args) {
        // 目标数组
        int[] arr = new int[]{2, 3, 4, 5, 7, 8, 10};
        //目标元素
        int target = 1;
        TestSearch testSearch = new TestSearch();
        int index = testSearch.binarySearch(target, arr);
        System.out.println(index);
    }

    /**
     *     普通查询
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
     *  顺序数组采用二分法查找
     */
    public int binarySearch(int target, int[] arr) {
        int index = -1;
        int begin = 0;
        int end = arr.length - 1;
        int middle = (begin + end) / 2;
        //另一种查找不在数组内的
//        if (target > arr[arr.length - 1] || target < arr[0]) {
//            return -1;
//        }
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
