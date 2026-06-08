package Amazon_Medium;

import java.util.*;

public class rottingOrange {

    public static class Axes{
        int x, y;
        Axes(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int findTotalMinToRotten(int[][] grid){
        Queue<Axes> q =  new LinkedList<>();
        int[] xdir = {0,1,0,-1};
        int[] ydir = {1,0,-1,0};

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new Axes(i, j));
                }
                else if(grid[i][j]==1) fresh++;
            }
        }

        if(fresh==0) return 0;

        int min = 0;

        //bfs
        while(!q.isEmpty() && fresh>0){
            int size = q.size();

            for(int i = 0; i<size; i++){
                Axes curr = q.poll();

                for(int d = 0; d<4; d++){
                   int newX = curr.x + xdir[d];
                   int newY = curr.y + ydir[d];
                   if(newX>=0 && newX<n && newY>=0 && newY<m && grid[newX][newY]==1){
                    grid[newX][newY] = 2;
                    fresh--;
                    q.add(new Axes(newX, newY));
                   }
                }

            }

            min++;
        }

        return fresh==0?min:-1;

    }
    public static void main(String[] args) {
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };

        int ans = findTotalMinToRotten(grid);
        System.out.println(ans);
    }
}
