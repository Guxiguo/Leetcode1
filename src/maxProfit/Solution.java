package maxProfit;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 *
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润 。
 */
class Solution {
    public static int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        for(int i:dp){
            i=0;
        }
        for(int i = 1;i<prices.length;i++){
            dp[i]=Math.max(dp[i-1]+prices[i]-prices[i-1],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}