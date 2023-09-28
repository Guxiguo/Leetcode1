package fullBloomFlowers;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 *
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 */
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        //Map<Integer,Integer> map = new HashMap<>();
        int[] count =new int[people.length];
        for(int i=0;i<people.length;i++){
            int a = 0;
            for(int j=0;j<flowers.length;j++){
                if(people[i]>=flowers[j][0]&&people[i]<=flowers[j][1]){
                    a++;

                }
            }
            count[i] = a;
        }
        return count;
    }
    /**
     *  public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
     *         int n = flowers.length;
     *         int[] starts = new int[n];
     *         int[] ends = new int[n];
     *         for (int i = 0; i < n; i++) {
     *             starts[i] = flowers[i][0];
     *             ends[i] = flowers[i][1];
     *         }
     *         Arrays.sort(starts);
     *         Arrays.sort(ends);
     *
     *         int m = persons.length;
     *         int[] ans = new int[m];
     *         for (int i = 0; i < m; i++) {
     *             int x = binarySearch(starts, persons[i] + 1);
     *             int y = binarySearch(ends, persons[i]);
     *             ans[i] = x - y;
     *         }
     *         return ans;
     *     }
     *
     *     int binarySearch(int[] arr, int target) {
     *         int res = arr.length;
     *         int left = 0, right = arr.length - 1;
     *         while (left <= right) {
     *             int mid = (left + right) >> 1;
     *             if (arr[mid] >= target) {
     *                 res = mid;
     *                 right = mid - 1;
     *             } else {
     *                 left = mid + 1;
     *             }
     *         }
     *         return res;
     *     }
     * }
     */
}
