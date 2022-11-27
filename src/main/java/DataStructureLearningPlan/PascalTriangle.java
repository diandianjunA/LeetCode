package DataStructureLearningPlan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        res.add(list1);
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < i+1; j++) {
                if(j==0){
                    list.add(res.get(i-1).get(j));
                } else if (j > i - 1) {
                    list.add(res.get(i-1).get(j-1));
                }else{
                    list.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
    @Test
    public void test(){
        for (List<Integer> integers : generate(5)) {
            System.out.println(integers);
        }

    }
}
