package DP;

import java.util.Arrays;

/**
 * @author huzhu
 * @date created in 2019-01-19 16:21
 * @explaination 动态规划-完全平方数
 */
public class Code_279_PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquares2(1));
    }

    //没有优化的DP
    public static int numSquares(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1] = 1;
        for(int i = 1;i <= n;i++){
            int mid = (int)Math.sqrt(i);
            if(mid * mid == i){
                dp[i] = 1;
            }else{
                for(int j = 1;j < i;j++){
                    dp[i] = Math.min(dp[j] + dp[i - j],dp[i]);
                }
            }
        }
        return dp[n];
    }

    //优化后的DP
    public static int numSquares2(int n){
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i = 0; i * i <= n;i++){
            dp[i * i] = 1;
        }
        for(int i = 1;i <= n;i++){
            for(int j = 1;i + j *j <= n;j++){
                dp[i + j * j] = Math.min(dp[i + j * j],dp[i] + 1);
            }
        }

        return dp[n];
    }
}
