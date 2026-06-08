package Amazon_Medium;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.PriorityQueue;

import Amazon_Easy.mergeSortedList;

public class MeetingRoomII {

    public static int findTotalRoom1(int[][] arr){
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(arr[0][1]);

        for(int i = 1; i<arr.length; i++ ){
            int end = pq.peek();
            if(end <= arr[i][0]){
                pq.poll();
            }
            pq.offer(arr[i][1]);
        }

        return pq.size();
    }

    public static int findTotalRoom2(int[][]arr){
        TreeMap<Integer, Integer> tmap = new TreeMap<>();

        for(int meeting[] : arr){
            tmap.put(meeting[0], tmap.getOrDefault(meeting[0],0)+1);
            tmap.put(meeting[1], tmap.getOrDefault(meeting[1], 0)-1);
        }

        int room = 0;
        int ans = 0;

        for(int k : tmap.keySet()){
            room += tmap.get(k);
            ans = Math.max(ans, room);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{0,30}, {5,10}, {15,20}};
        int minRoom = findTotalRoom1(arr);
        System.out.println(minRoom);
    }
}