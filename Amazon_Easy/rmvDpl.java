package Amazon_Easy;

import java.util.HashSet;
public class rmvDpl {

    // Brute force approach: Tc:O(n) & Sc : O(n)
    // public static int removeDuplicates(int[] nums){
    //     HashSet<Integer> set = new HashSet<>();
    //     for(int i = 0; i<nums.length; i++){
    //         set.add(nums[i]);
    //     }
    //     return set.size();
    // }

    //optimal approach : Tc: O(n) & Sc : O(1)
    public static int removeDuplicates(int[] nums){
      if(nums.length == 1) return 1;
       
      int i = 0;
      for(int j = 1; j<nums.length; j++){
        if(nums[i]<nums[j]){
            int temp = nums[i+1];
            nums[i+1] = nums[j];
            nums[j] = temp;
            i++;
        }
      }
      
      return i+1;

    } 

    public static void main(String []args){
        int nums[] = {0,1,1,1,2,2,3}; // 4
        int k = removeDuplicates(nums);
        System.out.print("k : "  + k);
    }
}
