package DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huzhu
 * @date created in 2019-03-04 16:57
 * @explaination n皇后
 */
public class Code_51_NQueens {
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    public static void dfs(char[][] board,int row,List<List<String>> res){
        if(row == board.length){
            res.add(build(board));
            return;
        }

        for(int col = 0;col < board.length;col++){
            if(isValid(board,row,col)){
                board[row][col] = 'Q';
                dfs(board,row + 1,res);
                board[row][col] = '.';
            }
        }

    }

    public static List<String> build(char[][] board){
        List<String> ret = new ArrayList<>();
        for(int i = 0;i < board.length;i++) {
            ret.add(new String(board[i]));
        }
        return ret;
    }

    public static boolean isValid(char[][] borad,int x,int y){
        for(int i = 0;i < x;i++){
            for(int j = 0;j < borad.length;j++){
                if (borad[i][j] == 'Q' && (y == j || Math.abs(x - i) == Math.abs(y - j)) ){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
