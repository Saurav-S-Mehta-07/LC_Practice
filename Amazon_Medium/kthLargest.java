package Amazon_Medium;

import java.util.PriorityQueue;

public class kthLargest {

    public static int findKthLargestEl(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int el : nums){
            pq.offer(el);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.poll();
    }
    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4}, k = 2;
        int ans = findKthLargestEl(nums, k);
        System.out.println(ans);
    }
}
