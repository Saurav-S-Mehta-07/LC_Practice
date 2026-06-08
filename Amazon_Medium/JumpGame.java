package Amazon_Medium;

import java.util.Arrays;

public class JumpGame {

    public static boolean helper(int[] nums, int i, int[] dp) {
       if(i >=nums.length-1) return true;
       if(nums[i] == 0) return false;
       if(dp[i]!=-1){
         return dp[i] == 1;
       }

       for(int j = 1; j<=nums[i]; j++){
        if(helper(nums, i+j, dp)){
            dp[i] = 1;
            return true;
        }
       }

       dp[i] = 0;
       return false;
    }

    //memoization
    public static boolean isReachedLast(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); // -1 = not computed

        return helper(nums, 0, dp);
    }

    //tabulation

    public static int minStep(int[] nums) {
        int[] dp = new int[nums.length];
        int n = nums.length;

        int inf = Integer.MAX_VALUE;
        Arrays.fill(dp,inf);

        dp[n-1] = 0;

        for(int i = n-2; i>=0; i--){
            int step = nums[i];
            for(int j = i+1; j<=i+step && j<n; j++){
                if(dp[j]!=inf){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[0]==inf?-1:dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 0, 1, 4};

        System.out.println(isReachedLast(nums));
        System.out.println(minStep(nums));
    }
}