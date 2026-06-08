package Amazon_Hard;
import java.util.*;
public class KthSmallestPairDist{

    public static void findKthSmallestPairDistance(int[] nums, int k){
        Arrays.sort(nums);
        int n = nums.length;
        int l  = 0;
        int h = nums[n-1]-nums[0];

        while(l<h){
            int mid = l + (h-l)/2;
            int count = 0;
            int j = 0;
            for(int i = 0; i<n; i++){
                while(j<n && nums[j]-nums[i] <= mid){
                    j++;
                }
                count += j-i-1;
            }

            if(count < k){
                l = mid+1;
            }
            else h = mid;
        }
        System.out.println(l);
    }
    public static void main(String[] args){
        int[] nums = {1,6,1};
        int k = 3;
        findKthSmallestPairDistance(nums, k);
    }
}