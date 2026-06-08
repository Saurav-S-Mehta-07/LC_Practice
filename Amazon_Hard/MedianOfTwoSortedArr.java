package Amazon_Hard;

public class MedianOfTwoSortedArr {

    public static double findMedian(int[] nums1, int[] nums2){
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1>n2){
            return findMedian(nums2, nums1);
        }

        int low = 0, high = n1;

        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = (n1+n2+1)/2 - mid1;

            double l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1-1];
            double r1 = (mid1 == n1)? Integer.MAX_VALUE : nums1[mid1];
            double l2 = (mid2 == 0)? Integer.MIN_VALUE : nums2[mid2-1];
            double r2 = (mid2 == n2)? Integer.MAX_VALUE : nums2[mid2];

            if(l1 <= r2 && l2<=r1){
                if((n1+n2) % 2 == 0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else return (double) Math.max(l1,l2);
            }

            else if(l1 > r2){
                high = mid1-1;
            }
            else {
                low = mid1+1;
            }
        }

        return 0;

    }
    public static void main(String[] args) {
        int []nums1 = {1,3};
        int [] nums2 = {2,5,7};
        System.out.println(findMedian(nums1, nums2));
    }
}
