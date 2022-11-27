package DataStructureLearningPlan;

import java.util.HashSet;

//36题
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> temp = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.'){
                    int size = temp.size();
                    temp.add(board[i][j]);
                    if(temp.size()==size){
                        return false;
                    }
                }
            }
        }
        for (int j = 0; j < board.length; j++) {
            HashSet<Character> temp = new HashSet<>();
            for (int i = 0; i < board.length; j++) {
                if(board[i][j]!='.'){
                    int size = temp.size();
                    temp.add(board[i][j]);
                    if(temp.size()==size){
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i=i+3) {
            for (int j = 0; j < board.length; j=j+3) {
                HashSet<Character> temp = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if(board[i+k][j+l]!='.'){
                            int size = temp.size();
                            temp.add(board[i+k][j+l]);
                            if(temp.size()==size){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    public boolean isValidSudokuPro(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] columns = new int[9][9];
        int[][][] subboxes = new int[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int index = c - '0' - 1;
                    rows[i][index]++;
                    columns[j][index]++;
                    subboxes[i / 3][j / 3][index]++;
                    if (rows[i][index] > 1 || columns[j][index] > 1 || subboxes[i / 3][j / 3][index] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
