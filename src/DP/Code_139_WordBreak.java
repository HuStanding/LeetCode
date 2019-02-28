package DP;

import java.util.Arrays;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-02-28 21:13
 * @explaination 动态规划——字符串分割
 */
public class Code_139_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict == null){
            return false;
        }
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = i - 1; j >= 0; j--){
                String word = s.substring(j,i);
                if(wordDict.contains(word) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }
}
