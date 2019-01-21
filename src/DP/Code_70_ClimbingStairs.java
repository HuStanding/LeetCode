package DP;

/**
 * @author huzhu
 * @date created in 2019-01-21 09:51
 * @explaination 动态规划爬楼梯
 */
public class Code_70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }

    //动态规划
    public static int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        int pre1 = 2;  //前一个
        int pre2 = 1;  //前两个
        for(int i = 2;i < n;i++){
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
