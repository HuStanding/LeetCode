package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 01:26
 * @explaination 带有重复数字的全排列
 */
public class Code_47_Permutations2 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,2,1}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,new ArrayList<>(),res);
        return res;
    }

    public static void dfs(int[] nums,boolean[] visited,List<Integer> permuteList,List<List<Integer>> res){
        if(permuteList.size() == nums.length){
            res.add(new ArrayList(permuteList));  //这里为什么需要使用new ArrayList
            return;
        }
        for(int i = 0;i < nums.length;i++){
            //确保在它前面的和它一样的数字已经都进入排列中
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            permuteList.add(nums[i]);
            dfs(nums,visited,permuteList,res);
            permuteList.remove(permuteList.size() - 1);
            visited[i] = false;
        }
    }
}
