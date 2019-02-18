package DP;

/**
 * @author huzhu
 * @date created in 2019-02-16 23:04
 * @explaination 最大摆动子序列
 */
public class Code_376_WiggleSubsequence {
    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));

    }

    public static int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int flag = -1, length = 1, prev = nums[0];
        int res;
        for (int i = 0; i < nums.length; ++i) {
            res = nums[i] > prev ? 1 : 0;
            if (nums[i] == prev) continue;
            if (flag != res) {
                flag = res;
                ++length;
            }
            prev = nums[i];
        }

        return length;
    }
}
