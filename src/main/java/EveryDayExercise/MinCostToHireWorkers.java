package EveryDayExercise;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        worker[] workers = new worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i]=new worker(quality[i],wage[i],1.0*wage[i]/quality[i]);
        }
        Arrays.sort(workers, new Comparator<worker>() {
            @Override
            public int compare(worker o1, worker o2) {
                if(o1.priceRatio>o2.priceRatio){
                    return 1;
                } else if (o1.priceRatio < o2.priceRatio) {
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        int totalQuality=0;
        double expense=0;
        double minExpense=Double.MAX_VALUE;
        for (int i = k-1; i < workers.length; i++) {
            Arrays.sort(workers,0,i, new Comparator<worker>() {
                @Override
                public int compare(worker o1, worker o2) {
                    return o1.quality - o2.quality;
                }
            });
            for (int j = 0; j < k - 1; j++) {
                totalQuality+=workers[j].quality;
            }
            totalQuality+=workers[i].quality;
            expense=totalQuality*workers[i].priceRatio;
            if(expense<minExpense){
                minExpense=expense;
            }
            totalQuality=0;
            expense=0;
        }
        return minExpense;
    }
    @Test
    public void test(){
        int[] quality={4,4,4,5};
        int[] wage={13,12,13,12};
        int k=2;
        System.out.println(mincostToHireWorkers(quality,wage,k));
    }
}
class worker{
    int quality;
    int wage;
    double priceRatio;
    public worker() {
    }
    public worker(int quality, int wage, double priceRatio) {
        this.quality = quality;
        this.wage = wage;
        this.priceRatio = priceRatio;
    }
}