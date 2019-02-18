package DP;

/**
 * @author huzhu
 * @date created in 2019-02-18 10:02
 * @explaination 0-1背包问题
 */
public class Code_Knapsack {
    public static int knapsack(int V, int N, int[] weights, int[] values) {
        int[] dp = new int[V + 1];
        for(int i = 1; i <= N;i++){
            for(int j = V; j >= weights[i - 1];j--){
                dp[j] = Math.max(dp[j],dp[j - weights[i - 1]] + values[i - 1]);
            }
        }
        return dp[V];
    }

    public static void main(String[] args) {
        System.out.println(knapsack(10,5,
                new int[]{2, 2, 6, 5, 4},new int[]{6, 3, 5, 4, 6}));
    }
}
