package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-01-17 20:19
 * @explaination 为运算表达式设计优先级
 */
public class Code_241_DifferentWaystoAddParentheses {
    public static void main(String[] args) {
        System.out.println(diffWaysToCompute("2-1-1"));
    }

    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i < input.length();i++){
            int c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int l : left){
                    for(int r : right){
                        switch (c){
                            case '+' : res.add(l + r);break;
                            case '-' : res.add(l - r);break;
                            case '*' : res.add(l * r);break;
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));

        }
        return res;
    }


}
