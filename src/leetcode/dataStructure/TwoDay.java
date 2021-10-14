package leetcode.dataStructure;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zk
 * @version V1.0.0
 * @date 2021/10/14
 **/
public class TwoDay {

    /**
     * 两数之和
     * <p>
     * 给定一个整数数组 nums和一个整数目标值 target，
     * 请你在该数组中找出和为目标值 target的那两个整数，
     * 并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。
     * 但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     *
     * @param nums   整数数组 nums
     * @param target 整数目标值
     * @return 数组下标
     */
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (hashMap.containsKey(num)) {
                arr[0] = i;
                arr[1] = hashMap.get(num);
            }
            hashMap.put(nums[i], i);
        }
        return arr;
    }

    /**
     * 合并两个有序数组
     * <p>
     * <p>
     * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，
     * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，
     * 后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
     *
     * @param nums1 非递减顺序 排列的整数数组nums1
     * @param m     nums1中的元素数目。
     * @param nums2 非递减顺序 排列的整数数组nums1
     * @param n     nums2 中的元素数目。
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0) {
            nums1 = nums2;
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
        for (int num : nums1) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 7, 11, 15};
//        int[] ints = twoSum(arr, 19);
//        for (int num : ints) {
//            System.out.println(num);
//        }
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{1};
        merge(nums1, 0, nums2, 1);
    }
}
