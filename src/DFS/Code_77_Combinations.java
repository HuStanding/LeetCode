package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 10:01
 * @explaination 组合
 */
public class Code_77_Combinations {
    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,k,1,new ArrayList<>(),res);
        return res;
    }

    public static void dfs(int n,int k,int start,List<Integer> combineList,List<List<Integer>> res){
        if(combineList.size() == k){
            res.add(new ArrayList(combineList));
            return;
        }
        for(int i = start;i <= n;i++){
            combineList.add(i);
            dfs(n,k,i + 1,combineList,res);
            combineList.remove(combineList.size() - 1);
        }
    }

}
