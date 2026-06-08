package Amazon_Medium;

public class NoOfIsland {

    public static int[] xdir  = {0,0,1,-1};
    public static int[] ydir = {1,-1,0,0};

    public static int findallIsland(int[][] grid){
        if(grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;

        int count_island = 0;
        for(int i =0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j);
                    count_island++;
                }
            }
        }
        return count_island;
    }

    public static void dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;
        
        for(int d = 0; d<4; d++){
           int newX = i + xdir[d];
           int newY = j + ydir[d];

           if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && grid[newX][newY]==1){
             dfs(grid,newX, newY);
           }
        }
    }
    public static void main(String[] args) {
        int[][] grid = {
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1}
        };

        int ans = findallIsland(grid);
        System.out.println(ans);
    }
}
