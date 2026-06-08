package Amazon_Easy;

public class missingNO {
    
    public static int findMissingValue(int[]nums){
        int n = nums.length;
        int nSum = n*(n+1)/2;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum = sum+nums[i];
        }
        return nSum-sum;
    }

    public static int findMissingValue2(int[]nums){
        int n = nums.length;
        int ans = n;
        for(int i = 0; i<n; i++){
          ans = ans ^ i ^ nums[i]; 
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[] = {2,4,3,1,0};
        int missingNum = findMissingValue2(nums);
        System.out.println("the missign number is : " + missingNum);
    }
}
