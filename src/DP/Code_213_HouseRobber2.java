package DP;

/**
 * @author huzhu
 * @date created in 2019-02-13 15:32
 * @explaination 动态规划-打家劫舍2
 */
public class Code_213_HouseRobber2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, n - 2), rob(nums, 1, n - 1));
    }

    public static int rob(int[] nums, int s, int e) {
        int n = nums.length;
        if (e - s == 0) {
            return nums[s];
        }
        if (e - s == 1) {
            return Math.max(nums[s], nums[s + 1]);
        }
        int[] dp = new int[n];
        dp[s] = nums[s];
        dp[s + 1] = nums[s + 1];
        dp[s + 2] = nums[s] + nums[s + 2];
        for (int i = s + 3; i <= e; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }
        return Math.max(dp[e], dp[e - 1]);
    }
}
