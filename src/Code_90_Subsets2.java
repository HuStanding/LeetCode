import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 16:34
 * @explaination 数组（包含重复元素）的子集
 */
public class Code_90_Subsets2 {
    public static void main(String[] args) {
        System.out.println(subsetsWithDup(new int[]{1,2,2}));

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums,visited,new ArrayList<>(),0,res);
        return res;
    }

    public static void dfs(int[] nums,boolean[] visited,List<Integer> list,int start,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums,visited,list,i + 1,res);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
