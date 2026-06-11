package Amazon_Hard;

import java.util.Stack;

public class LongestParentheses{
    public static int findLongestLength(String str){
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int ans = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push(i);
            else{
                if(!stack.isEmpty()){
                    stack.pop();
                }
                if(!stack.isEmpty()){
                    ans = Math.max(ans, i - stack.peek());
                }
                else{
                    stack.push(i);
                }

            }
        }
        return ans;
    }
    public static void main(String[] args){
        String str = ")()()(()";
        System.out.println(findLongestLength(str));
    }
}