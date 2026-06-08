package Amazon_Medium;

import java.util.PriorityQueue;

public class FindkClosest {
   
    public static void findKClosestEl(int[]arr, int k, int x){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int el : arr){
            if(k>0){
                pq.offer(el);
                k--;
            }
            else if(Math.abs(pq.peek()-x) > Math.abs(el-x)){
                pq.poll();
                pq.offer(el);
            }
        }

        System.out.println(pq);
    }
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5};
    int k = 4, x = 3;
    findKClosestEl(arr, k, x);
  }   
}
