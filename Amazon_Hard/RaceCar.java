package Amazon_Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RaceCar{

    public static int findMinStep(int target){
        int dp[]  = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int n = 1;

        for(int i = 1; i<=target; i++){
            if(i == Math.pow(2,n)-1){
                dp[i] = n;
                n++;
            }

            else{
                for(int j = 0; j<n-1; j++){
                    dp[i] = Math.min(dp[i], n+j+1+dp[i- (int)Math.pow(2,n-1) + (int)Math.pow(2,j)]);
                }
                dp[i] = Math.min(dp[i], n+1+dp[(int)Math.pow(2,n)-1-i]);
            }
        }
        return dp[target];

    }


    public static class State{
        int pos, speed;
        State(int p, int s){
            pos = p;
            speed = s;
        }
    }

    public static int findMinStep2(int target){
        Queue<State> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        q.add(new State(0,1));
        set.add("0,1");

        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i<size; i++){
                State curr = q.poll();

                if(curr.pos == target) return steps;

                //accelarate
                int newPos = curr.pos + curr.speed;
                int newSpeed = curr.speed *2;

                String key1 = newPos + "," + newSpeed;
                if(Math.abs(newPos) <= 2*target && !set.contains(key1)){
                    set.add(key1);
                    q.offer(new State(newPos, newSpeed));
                }

                //reverse
                int revSpeed = curr.speed>0?-1:1;
                String key2 = curr.pos + "," + revSpeed;
                
                if(!set.contains(key2)){
                    set.add(key2);
                    q.offer(new State(curr.pos, revSpeed));
                }

            }
            steps++;
        }
        return -1;
    }
    public static void main(String[] args) {
        int target = 3;
        System.out.print(findMinStep2(target));
    }
}