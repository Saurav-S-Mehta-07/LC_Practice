package Amazon_Medium;

public class LongestPalindrome {

    public static void longestPalindrome(String s){
        int start = 0, maxLen = 1;

        int l = 0, r = 0;

        for(int i = 0; i<s.length(); i++){
            //even
            l = i;
            r = i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > maxLen){
                    start = l;
                    maxLen = r-l+1;
                }
                l--;
                r++;
            }
            //odd

            l = i-1;
            r = i+1;

            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > maxLen){
                    start = l;
                    maxLen = r-l+1;
                }
                l--;
                r++;
            }
        }

        System.out.println(s.substring(start,start+maxLen));
    }
    public static void main(String[] args) {
        String s = "babad";
        longestPalindrome(s);
    }
}
