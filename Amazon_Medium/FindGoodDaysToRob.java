package Amazon_Medium;

import java.util.*;

public class FindGoodDaysToRob {

    public static void findGoodDays(int[] security, int time){
        int n = security.length;
        List<Integer> ans = new ArrayList<>();
        int countDays = 0;
        int[] prefix = new int[n];
        int[] suffix  = new int[n];

        prefix[0] = 0;
        for(int i = 1; i<n; i++){
            if(security[i]<=security[i-1]){
                countDays++;
            }
            else countDays=0;
            prefix[i] = countDays;
        }

        countDays = 0;
        suffix[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            if(security[i]<=security[i+1]){
                countDays++;
            }
            else countDays=0;
            suffix[i] = countDays;
        }

        for(int i = 0; i<n; i++){
            if(prefix[i]>=time && suffix[i]>=time){
                ans.add(i);
            }
        }
        System.out.print(ans);
    }
    public static void main(String[] args) {
        int [] security = {5,3,3,3,5,6,2};
        int time = 2;
        findGoodDays(security, time);
    }
}
