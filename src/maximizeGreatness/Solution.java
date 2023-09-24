package maximizeGreatness;

import java.util.Arrays;

public class Solution {
    public static int maximizeGreatness(int[] nums) {
        Arrays.sort(nums); // 对数组进行排序，下面使用双指针 + 贪心
        int fast = 0, slow = 0, result = 0;
        while (fast < nums.length) {
            if (nums[slow] == nums[fast]) {
                ++result;
                ++fast;
                ++slow;
            }
            ++fast;

        }
        return result;
    }
}
//        int fast = 0, slow = 0, length = nums.length, result = 0;
//        while (fast < length) {
//            if (nums[slow] < nums[fast]) {
//                ++result; // 符合大小关系条件，结果 + 1
//                ++slow; // 符合条件，慢指针向前移动
//            }
//            ++fast; // 不论是否符合条件，快指针都要向前移动
//        }
//        return result;
//    }


