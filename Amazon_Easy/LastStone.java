package Amazon_Easy;

import java.util.PriorityQueue;

public class LastStone {

    public static int lastStoneWeight(int[] stones){
        PriorityQueue<Integer> pq= new PriorityQueue<>((a,b)->b-a);
        for(int i = 0; i<stones.length; i++){
            pq.add(stones[i]);
        }

        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();

            if(x!=y){
                pq.add(x-y);
            }
        }

        return pq.size()==0?0:pq.peek();

    }
  public static void main(String[] args) {
    int[] stones = {2,7,4,1,8,};
    int ans = lastStoneWeight(stones);
    System.out.println(ans);
  }   
}
