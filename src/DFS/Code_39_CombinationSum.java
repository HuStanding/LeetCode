package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 10:58
 * @explaination 组合求和
 */
public class Code_39_CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5},8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates,target,new ArrayList<>(),0,0,res);
        return res;
    }

    public static void dfs(int[] candidates,int target,List<Integer> list,int start,int sum,List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }else if(sum > target){
            return;
        }
        for(int i = start;i < candidates.length;i++){
            list.add(candidates[i]);
            dfs(candidates,target,list,i,sum + candidates[i],res);
            list.remove(list.size() - 1);
        }
    }
}
