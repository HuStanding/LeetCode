package DP;

import java.util.Arrays;

/**
 * @author huzhu
 * @date created in 2019-03-06 20:23
 * @explaination 字符构成最多的字符串
 */
public class Code_474_OnesAndZeroes {
    public static int findMaxForm(String[] strs, int m, int n) {
        /*转换为多维0-1背包问题
        这里用dp[i][j][k]表示前i个字符串在0个数不超过j、1个数不超过k时最多能选取的字符串个数。
        统计第i个字符串中0和1个数分别为cnt0和cnt1，
        如果取第i个字符串则dp[i][j][k] = dp[i-1][j-cnt0][k-cnt1] + 1，
        如果不取第i个字符串则dp[i][j][k] = dp[i-1][j][k]，
        取两者大的作为dp[i][j][k]的值。由于dp[i][j][k]只与dp[i-1][*][*]相关，
        所以这里可以重复使用m*n个数据将空间复杂度降为O(m*n)，只需在遍历时从后向前遍历即可*/

        int[][] dp = new int[m + 1][n + 1];
        int cnt0 = 0, cnt1 = 0;
        for(String s : strs){
            cnt0 = cnt1 = 0;
            for(char c : s.toCharArray()){
                if(c == '0') cnt0++;
                else if(c == '1') cnt1++;
            }
            for(int i = m;i >= cnt0;i--){
                for(int j = n;j  >= cnt1;j--){
                    dp[i][j] = Math.max(dp[i][j],dp[i - cnt0][j - cnt1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"},5,3));
        System.out.println(findMaxForm(new String[]{"10", "0", "1"},1,1));
    }
}
