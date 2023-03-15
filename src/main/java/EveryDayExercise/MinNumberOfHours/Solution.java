package EveryDayExercise.MinNumberOfHours;

import org.junit.Test;

public class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int time=0;
        for (int i = 0; i < energy.length; i++) {
            if(initialEnergy<=energy[i]){
                time+=energy[i]-initialEnergy+1;
                initialEnergy=1;
            }else{
                initialEnergy-=energy[i];
            }
            if(initialExperience<=experience[i]){
                time+=experience[i]-initialExperience+1;
                initialExperience=experience[i]+1;
            }
            initialExperience+=experience[i];
        }
        return time;
    }

    @Test
    public void test1(){
        int initialEnergy=5;
        int initialExperience=3;
        int[] energy={1,4,3,2};
        int[] experience={2,6,3,1};
        System.out.println(minNumberOfHours(initialEnergy,initialExperience,energy,experience));
    }

    @Test
    public void test2(){
        int initialEnergy=2;
        int initialExperience=4;
        int[] energy={1};
        int[] experience={3};
        System.out.println(minNumberOfHours(initialEnergy,initialExperience,energy,experience));
    }
}
