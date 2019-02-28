package DP;

/**
 * @author huzhu
 * @date created in 2019-02-28 22:35
 * @explaination 动态规划——目标和
 */
public class Code_494_TargetSum {
    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum < S || (sum + S ) % 2 != 0){
            return 0;
        }
        int target = (sum + S ) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 0 ; i < nums.length; i++){
            for(int j = target; j >= nums[i]; j--){
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1},3));
    }
}
