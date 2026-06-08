package Amazon_Easy;
import java.util.*;;
public class pascal {

    public static void printPascal(int n){
        int[][] pascalTriangle = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<=i; j++){
                if(j==0 || i==j){
                    pascalTriangle[i][j] = 1;
                }
                else{
                    pascalTriangle[i][j] = pascalTriangle[i-1][j-1] + pascalTriangle[i-1][j];
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<=i; j++){
               System.out.print(" " + pascalTriangle[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("enter n : ");
        int n = sc.nextInt();

        printPascal(n);
    }
}
