package DP;

/**
 * @author huzhu
 * @date created in 2019-02-16 23:04
 * @explaination 最大摆动子序列
 */
public class Code_376_WiggleSubsequence {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));

    }

    public static int wiggleMaxLength(int[] nums){
        if(nums.length < 2){
            return nums.length;
        }

        int len = nums.length;
        int flag = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] == nums[i - 1]){
                len--;
            }else if(nums[i] > nums[i - 1]){
                if(flag == 1) len--;
                else flag = 1;
            }else{
                if(flag == -1) len--;
                else flag = -1;
            }
        }
        return len;
    }
}
