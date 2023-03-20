package FirstPackage.SolveSudoku;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public void solveSudoku(char[][] board) {
        List<Character>[] row = new List[9];
        List<Character>[] col = new List[9];
        List<Character>[] block = new List[9];
        for (int i = 0; i < 9; i++) {
            row[i]= new ArrayList<>();
            col[i]= new ArrayList<>();
            block[i]=new ArrayList<>();
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.'){
                    row[i].add(board[i][j]);
                    col[j].add(board[i][j]);
                    block[(i/3)*3+j/3].add(board[i][j]);
                }
            }
        }
        deal(board,row,col,block,0,0);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public boolean deal(char[][] board,List<Character>[] row,List<Character>[] col,List<Character>[] block,int x,int y){
        if(x== board.length){
            x=0;
            y++;
        }
        if(y==board[0].length){
            return true;
        }
        if(board[x][y]=='.'){
            for (int k = 0; k < 9; k++) {
                char c= (char) ('1'+k);
                if(!row[x].contains(c)&&!col[y].contains(c)&&!block[(x/3)*3+y/3].contains(c)){
                    board[x][y]=c;
                    row[x].add(c);
                    col[y].add(c);
                    block[(x/3)*3+y/3].add(c);
                    boolean deal = deal(board, row, col, block, x, y);
                    if(!deal){
                        row[x].remove(row[x].indexOf(c));
                        col[y].remove(col[y].indexOf(c));
                        block[(x/3)*3+y/3].remove(block[(x/3)*3+y/3].indexOf(c));
                        board[x][y]='.';
                    }else{
                        return true;
                    }
                }
            }
        }else{
            return deal(board, row, col, block, x+1, y);
        }
        return false;
    }

    @Test
    public void test1(){
        char[][] board={{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(board);
    }
}
