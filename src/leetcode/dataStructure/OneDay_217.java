package leetcode.dataStructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zk
 * @version V1.0.0
 * @date 2021/10/13
 **/
public class OneDay_217 {
    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果存在一值在数组中出现至少两次，函数返回 true 。
     * 如果数组中每个元素都不相同，则返回 false 。
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() < nums.length) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(arr));
    }
}
