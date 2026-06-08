package Amazon_Medium;

import java.util.Arrays;

public class UniquePath {

    //recursion O(2^(m+n) sc: O(m+n))
    public static int findUniquePath(int m, int n){
        return helper(m,n,0,0);
    }

    public static int helper(int m, int n, int i, int j){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        return helper(m, n, i, j+1) + helper(m, n, i+1, j);
    }

    // memoization method
    public static int findUniquePathM(int m, int n){
        int[][] dp = new int[m][n];
        for(int i= 0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(m,n,0,0,dp);
    }

    public static int solve(int m, int n, int i, int j, int[][]dp){
        if(i>=m || j>=n) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        return dp[i][j] = solve(m, n, i+1, j, dp) + solve(m, n, i, j+1, dp);
    }
   public static void main(String[] args) {
     int m = 3, n = 2;
     System.out.println(findUniquePathM(m,n));
   }   
}
