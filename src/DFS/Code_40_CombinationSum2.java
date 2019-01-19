package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 15:02
 * @explaination 组合总和2
 */
public class Code_40_CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        dfs(candidates,target,visited,new ArrayList<>(),0,0,res);
        return res;
    }

    public static void dfs(int[] candidates,int target,boolean[] visited,List<Integer> list,int start,int sum,List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }else if(sum > target){
            return;
        }
        for(int i = start;i < candidates.length;i++){
            if(i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]){
                continue;
            }
            visited[i] = true;
            list.add(candidates[i]);
            dfs(candidates,target,visited,list,i + 1,sum + candidates[i],res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
