package Amazon_Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class courseSchedule{

    public static boolean isPossibleTofinish(int[][]arr, int n){
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] indeg = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
               adj[i] = new ArrayList<Integer>();
        }
        for(int x[] : arr){
            adj[x[1]].add(x[0]);
            indeg[x[0]]++;
        }

        for(int i = 0; i<n; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()){
            int curr = q.poll();
            count++; 
            for(int i : adj[curr]){
                indeg[i]--;
                if(indeg[i]==0){
                    q.add(i);
                }
            }
        }

        return count==n;


    }
    public static void main(String[] args){
       int[][] arr = {
        {1,0}, {2,0},{3,1},{3,2}
       };

       
       System.out.println(isPossibleTofinish(arr, 4));
    }
}