package Amazon_Medium;

public class CarPolling {

    public static boolean isPossibleToDrop(int[][] trips, int capacity){
        int []M = new int[1000];

        for(int i = 0; i<trips.length; i++){
            M[trips[i][1]] += trips[i][0];
            M[trips[i][2]] -= trips[i][0];
        }

        for(int i = 0; capacity>=0 && i<M.length; i++){
            capacity = capacity - M[i];
        }

        return capacity>=0;

    }
    public static void main(String[] args) {
        int [][] trips = {
            {2,1,5},
            {3,3,7}
        };
        int capacity = 5;
        boolean ans = isPossibleToDrop(trips, capacity);
        System.out.println(ans);
    }
}
