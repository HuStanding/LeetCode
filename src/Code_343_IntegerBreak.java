import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-19 12:55
 * @explaination 动态规划-数字划分
 */
public class Code_343_IntegerBreak {
    public static void main(String[] args) {
        System.out.println(integerBreak3(10));
    }

    //递归-自顶向下
    public static int integerBreak(int n) {
        return dfs(n);
    }

    public static int dfs(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        int res = 0;
        for(int i = 1;i < n;i++){
            res = Math.max(res,Math.max(i * dfs(n - i),i * (n - i)));
        }
        return res;
    }

    //动态规划-自下向上
    public static int integerBreak2(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 2;i <= n;i++){
            for(int j = 1;j <= i - 1;j++){
                dp[i] = Math.max(dp[i],Math.max(j * dp[i - j],j * (i - j)));
            }
        }
        return dp[n];
    }

    //数学方法
    public static int integerBreak3(int n){
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        int res = 1;
        while(n > 4){
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

}
