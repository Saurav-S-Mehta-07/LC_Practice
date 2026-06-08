package Amazon_Medium;

public class SumOfSubArr {

    public static int findSumOfSubarray(int[] nums){
        int ans = 0;
        
        for(int i = 0; i<nums.length; i++){
            int minV = nums[i];
            int maxV = nums[i];
            for(int j = i; j<nums.length; j++){
                maxV = Math.max(maxV,nums[j]);
                minV = Math.min(minV, nums[j]);
                ans = ans + (maxV - minV);
            }
        }
        return ans;
    }
   public static void main(String[] args) {
    int nums[]  = {3,1,2};
    int ans = findSumOfSubarray(nums);
    System.out.println(ans);
   }   
}
