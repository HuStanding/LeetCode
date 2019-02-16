package DP;

/**
 * @author huzhu
 * @date created in 2019-02-15 22:49
 * @explaination 动态规划-最长递增子序列
 */
public class Code_300_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0;i < nums.length;i++){
            int max = 1;
            for(int j = 0;j < i;j++){
                if(nums[i] > nums[j]){
                    max = Math.max(max,dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for(int i = 0;i < nums.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }


}
