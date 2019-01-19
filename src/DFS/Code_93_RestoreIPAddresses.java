package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-16 19:30
 * @explaination IP地址划分
 */
public class Code_93_RestoreIPAddresses {

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("25525511135"));
    }


    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        if(s == null || s.length() < 4){
            return res;
        }
        dfs(s,0,"",res);
        return res;
    }

    public static void dfs(String s,int index,String prefix,List<String> res){
        if(index == 4){
            if(s.length() == 0) {
                res.add(prefix);
            }
            return;
        }

        for(int k = 0;k < 3 && k < s.length();k++){
            if(k != 0 && s.charAt(0) == '0'){
                break;
            }
            String part = s.substring(0,k + 1);
            if(Integer.parseInt(part) <= 255){
                dfs(s.substring(k + 1),index + 1,prefix.length() == 0 ?
                        part : prefix + "." + part,res);
            }
        }
    }

}
