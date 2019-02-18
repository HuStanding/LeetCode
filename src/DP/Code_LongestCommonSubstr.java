package DP;

/**
 * @author huzhu
 * @date created in 2019-02-18 09:40
 * @explaination 最长公共子序列
 */
public class Code_LongestCommonSubstr {
    public static void main(String[] args) {
        System.out.println(longestCommonSubstr("5828947","23547"));
    }

    public static int longestCommonSubstr(String a, String b){
        int n1 = a.length();
        int n2 = b.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for(int i = 1; i <= n1; i++){
            for(int j = 1;j <= n2; j++){
                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}
