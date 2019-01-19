package DFS;

/**
 * @author huzhu
 * @date created in 2019-01-17 18:48
 * @explaination 数独游戏
 */
public class Code_37_SudokuSolver {
    public static void main(String[] args) {
        char[][] borad = 
        {{'5','3','.','.','7','.','.','.','.'},
        {'6','.','.','1','9','5','.','.','.'},
        {'.','9','8','.','.','.','.','6','.'},
        {'8','.','.','.','6','.','.','.','3'},
        {'4','.','.','8','.','3','.','.','1'},
        {'7','.','.','.','2','.','.','.','6'},
        {'.','6','.','.','.','.','2','8','.'},
        {'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(borad);
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                System.out.print(borad[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(char[][] board) {
        dfs(board);
    }

    public static boolean dfs(char[][] borad){
        for(int i = 0;i < 9;i++){
            for(int j = 0;j < 9;j++){
                if(borad[i][j] == '.'){
                    for(char c = '1';c <= '9';c++){
                        if(isValid(borad,i,j,c)){
                            borad[i][j] = c;
                            if(dfs(borad)){
                                return true;
                            }else {
                                borad[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(char[][] board,int row,int col,char c){
        for(int i = 0;i < 9;i++){
            //检查行、列是否有重复
            if(board[row][i] == c || board[i][col] == c){
                return false;
            }
            //检查九宫格是否有重复
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c){
                return false;
            }
        }
        return true;
    }
}
