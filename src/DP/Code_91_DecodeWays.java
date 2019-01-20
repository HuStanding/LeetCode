package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-20 15:05
 * @explaination 动态规划-解析数字
 */
public class Code_91_DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings2("226"));
    }

    private static int res;

    //DFS方法
    public static int numDecodings(String s) {
        res = 0;
        dfs(s);
        return res;
    }

    public static void dfs(String s){
        if(0 == s.length()){
            res++;
            return;
        }
        for(int k = 0;k < 2 && k < s.length();k++){
            if((k != 0 && s.charAt(0) == '0') || (1 == s.length() && s.charAt(0) == '0')){
                break;
            }
            String part = s.substring(0,k + 1);
            if(Integer.parseInt(part) <= 26 && Integer.parseInt(part) >= 1){
                dfs(s.substring(k + 1));
            }
        }
    }

    //DP方法
    public static int numDecodings2(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1;i <= s.length();i++){
            if(s.charAt(i - 1) == '0'){
                dp[i - 1] = 0;
            }
            if(i >= 2 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6'))){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
