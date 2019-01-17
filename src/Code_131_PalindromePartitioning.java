import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 16:55
 * @explaination 回文串的划分
 */
public class Code_131_PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s,new ArrayList<>(),res);

        return res;
    }

    public static void dfs(String s,List<String> list,List<List<String>> res){
        if(s.length() == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i < s.length();i++){
            if(isPalindrome(s,0,i)){
                list.add(s.substring(0,i + 1));
                dfs(s.substring(i + 1),list,res);
                list.remove(list.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s,int begin,int end){
        while(begin <= end){
            if(s.charAt(begin++) != s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
