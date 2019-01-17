import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-16 22:38
 * @explaination 全排列
 */
public class Code_46_Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
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
