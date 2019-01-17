import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 16:04
 * @explaination 数组的子集（不包含重复子集）
 */
public class Code_78_Subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,new ArrayList<>(),0,res);
        return res;
    }

    public static void dfs(int[] nums,List<Integer> list,int start,List<List<Integer>> res){
        res.add(new ArrayList<>(list));
        for(int i = start;i < nums.length;i++){
            list.add(nums[i]);
            dfs(nums,list,i + 1,res);
            list.remove(list.size() - 1);
        }
    }
}
