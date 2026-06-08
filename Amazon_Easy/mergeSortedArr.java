package Amazon_Easy;

public class mergeSortedArr {

    public static void Merge(int[]nums1, int[]nums2, int m, int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i]>nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while(j>=0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }

        for(int x = 0; x<m+n; x++){
            System.out.print(nums1[x] + " ");
        }
    }
    public static void main(String[] args){
        int nums1[] = {7,8,9,0,0,0};
        int nums2[] = {2,5,6};
        int m = 3, n = 3;
        Merge(nums1, nums2, m, n);
    }
}
