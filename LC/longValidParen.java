package LC;

import java.util.Stack;

//longest valid parentheses
public class longValidParen {

    public static int findLongest(String s){
        if(s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        int maxlen = Integer.MIN_VALUE;

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i)=='(') stack.push(i);
            else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                     maxlen = Math.max(maxlen, i - stack.peek());
                }
            }
        }
        return maxlen!=Integer.MIN_VALUE?maxlen:0;
    }
    public static void main(String[] args) {
        String s = "())()()";

        System.out.println(findLongest(s));//4
    }
}
