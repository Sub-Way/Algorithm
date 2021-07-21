/*
    Stack을 안쓰고도 풀 수 있다!
*/

import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){
            if(!st.isEmpty() && st.peek() == '(' && s.charAt(i) == ')'){
                st.pop();
            }else{
                st.push(s.charAt(i));
            }
        }

        if(st.size() > 0)
            answer = false;

        return answer;
    }
}
