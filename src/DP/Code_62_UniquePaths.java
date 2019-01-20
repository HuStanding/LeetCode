package DP;

/**
 * @author huzhu
 * @date created in 2019-01-20 21:37
 * @explaination 动态规划-不同路径
 */
public class Code_62_UniquePaths {
    public static void main(String[] args) {
        System.out.println(uniquePaths2(7,3));
    }

    //递归
    public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1){
            return 1;
        }else{
            return uniquePaths(m,n - 1) + uniquePaths(m - 1,n);
        }
    }

    //动态规划1
    public static int uniquePaths2(int m,int n){
        int[][] res = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(i == 0 || j == 0){
                    res[i][j] = 1;
                }else{
                    res[i][j] = res[i][j - 1] + res[i - 1][j];
                }
            }
        }
        return res[m - 1][n - 1];
    }
}
