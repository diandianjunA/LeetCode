package EveryDayExercise;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ExamRoomTest{
    @Test
    public void test1(){
        ExamRoom examRoom = new ExamRoom(10);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(4);
        System.out.println(examRoom.seat());
    }
}

class ExamRoom {

    int capacity;
    TreeSet<Integer> seat;
    PriorityQueue<int[]> block;

    public ExamRoom(){

    }

    public ExamRoom(int n) {
        capacity=n;
        seat=new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        block=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int d1=o1[1]-o1[0];
                int d2=o2[1]-o2[0];
                return d1/2>d2/2||(d1/2==d2/2&&o1[0]<o2[0])?-1:1;
            }
        });
    }

    public int seat() {
        if(seat.isEmpty()){
            seat.add(0);
            return 0;
        }
        int left=seat.first();
        int right=capacity-1-seat.last();
        while(seat.size()>=2){
            int[] peek = block.peek();
            assert peek != null;
            if (seat.contains(peek[0]) && seat.contains(peek[1]) && seat.higher(peek[0]) == peek[1]) {
                int d=peek[1]-peek[0];
                if(d/2<right||d/2<=left){
                    break;
                }
                block.poll();
                block.add(new int[]{peek[0],peek[0]+d/2});
                block.add(new int[]{peek[0]+d/2,peek[1]});
                seat.add(peek[0]+d/2);
                return peek[0]+d/2;
            }
            block.poll();
        }
        if(right>left){
            block.add(new int[]{seat.last(),capacity-1});
            seat.add(capacity-1);
            return capacity-1;
        }else{
            block.add(new int[]{0,seat.first()});
            seat.add(0);
            return 0;
        }
    }

    public void leave(int p) {
        if(p!=seat.first()&&p!=seat.last()){
            block.add(new int[]{seat.lower(p),seat.higher(p)});
        }
        seat.remove(p);
    }
}
