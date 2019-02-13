package DP;

/**
 * @author huzhu
 * @date created in 2019-02-13 15:04
 * @explaination
 */
public class Code_198_HouseRobber {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }

    public static int rob(int[] nums){
        int n = nums.length;
        if(nums.length == 0 || nums == null){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }else if(nums.length == 2){
            return Math.max(nums[0],nums[1]);
        }else{
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = nums[1];
            dp[2] = nums[0] + nums[2];
            for(int i = 3;i < nums.length;i++){
                dp[i] = Math.max(dp[i - 2],dp[i - 3]) + nums[i];
            }
            return Math.max(dp[nums.length - 1],dp[nums.length - 2]);
        }
    }
}
