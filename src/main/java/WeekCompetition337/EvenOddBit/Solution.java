package WeekCompetition337.EvenOddBit;

public class Solution {
    public int[] evenOddBit(int n) {
        int even=0;
        int odd=0;
        String s = Integer.toBinaryString(n);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(s.length()-i-1)=='1'){
                if(i%2==0){
                    even++;
                }else{
                    odd++;
                }
            }
        }
        return new int[]{even,odd};
    }
}
