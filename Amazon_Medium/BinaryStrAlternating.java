package Amazon_Medium;

public class BinaryStrAlternating {

    public static int findMinSwap(String s){

        int ones = 0, zeros = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1') ones++;
            else zeros++;
        }

        if(Math.abs(ones-zeros)>1) return -1;

        int missing0 = 0, missing1 = 0;

        for(int i = 0; i<s.length(); i+=2){
            if(s.charAt(i) != '0') missing0++;
            else missing1++;
        }

        return ones==zeros?Math.min(missing0, missing1):zeros>ones?missing0:missing1;

        
    }
    public static void main(String[] args) {  
        String s = "111000";
        int ans = findMinSwap(s);
        System.out.println(ans);
    }
}
