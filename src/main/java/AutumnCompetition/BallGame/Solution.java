package AutumnCompetition.BallGame;

import java.util.ArrayList;

public class Solution {
    public int[][] ballGame(int num, String[] plate) {
        ArrayList<Integer[]> res = new ArrayList<>();
        for (int i = 1; i < plate[0].length()-1; i++) {
            if(plate[0].charAt(i)=='.'){
                if(inToHole(num, plate, 0, i, 0, 's')){
                    res.add(new Integer[]{0,i});
                }
            }
            if(plate[plate.length - 1].charAt(i)=='.'){
                if(inToHole(num, plate, plate.length - 1, i, 0, 'w')){
                    res.add(new Integer[]{plate.length - 1,i});
                }
            }
        }
        for (int i = 1; i < plate.length-1; i++) {
            if(plate[i].charAt(0)=='.'){
                if(inToHole(num, plate, i, 0, 0, 'd')){
                    res.add(new Integer[]{i,0});
                }
            }
            if(plate[i].charAt(plate[0].length()-1)=='.'){
                if(inToHole(num, plate, i, plate[0].length() - 1, 0, 'a')){
                    res.add(new Integer[]{i,plate[0].length()-1});
                }
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            result[i][0]=res.get(i)[0];
            result[i][1]=res.get(i)[1];
        }
        return result;
    }
    public boolean inToHole(int num,String[] plate,int x,int y,int index,char direction){
        if(index>num){
            return false;
        }
        if(x>= plate.length||y>=plate[0].length()||x<0||y<0){
            return false;
        }
        if(plate[x].charAt(y)=='.'){
            switch (direction){
                case 'w':return inToHole(num,plate,x-1,y,index+1,direction);
                case 'a':return inToHole(num,plate,x,y-1,index+1,direction);
                case 'd':return inToHole(num,plate,x,y+1,index+1,direction);
                case 's':return inToHole(num,plate,x+1,y,index+1,direction);
            }
        } else if (plate[x].charAt(y) == 'E') {
            switch (direction){
                case 'w':return inToHole(num,plate,x,y+1,index+1,'d');
                case 'a':return inToHole(num,plate,x-1,y,index+1,'w');
                case 'd':return inToHole(num,plate,x+1,y,index+1,'s');
                case 's':return inToHole(num,plate,x,y-1,index+1,'a');
            }
        } else if (plate[x].charAt(y) == 'W') {
            switch (direction){
                case 'w':return inToHole(num,plate,x,y-1,index+1,'a');
                case 'a':return inToHole(num,plate,x+1,y,index+1,'s');
                case 's':return inToHole(num,plate,x,y+1,index+1,'d');
                case 'd':return inToHole(num,plate,x-1,y,index+1,'w');
            }
        }
        return true;
    }
}
