package EveryDayExercise.CountStudents;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            queue.add(students[i]);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            int length=0;
            Integer poll = queue.poll();
            while(length<=queue.size()){
                if(poll==sandwiches[i]){
                    break;
                }else{
                    queue.add(poll);
                    poll=queue.poll();
                    length++;
                }
            }
            if(poll!=sandwiches[i]){
                return students.length-i;
            }
        }
        return 0;
    }
    @Test
    public void test1(){
        int[] student={1,1,0,0};
        int[] sandwiches={0,1,0,1};
        System.out.println(countStudents(student,sandwiches));
    }
    @Test
    public void test2(){
        int[] student={1,1,1,0,0,1};
        int[] sandwiches={1,0,0,0,1,1};
        System.out.println(Solution2.countStudents(student,sandwiches));
    }
}
class Solution2 {
    public static int countStudents(int[] students, int[] sandwiches) {
        int s1 = Arrays.stream(students).sum();
        int s0 = students.length - s1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0 && s0 > 0) {
                s0--;
            } else if (sandwiches[i] == 1 && s1 > 0) {
                s1--;
            } else {
                break;
            }
        }
        return s0 + s1;
    }
}