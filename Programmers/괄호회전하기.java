import java.util.*;

class Solution {
    static int answer;
    
    public int solution(String s) {

        for(int i = 0; i<s.length(); i++){
            
            String head = s.substring(0,i);
            String str = s.substring(i,s.length()) + head;
            check(str);
        }
        
        return answer;
    }
    
    public void check(String s){
        
        Stack<Character> st = new Stack<Character>();
        
        for(int i = 0; i<s.length(); i++){
            if(st.isEmpty()){
                st.add(s.charAt(i));
            }else{
                if(st.peek() == '{' && s.charAt(i) =='}')
                    st.pop();
                else if(st.peek() == '{' && s.charAt(i) !='}')
                    st.add(s.charAt(i));
                else if(st.peek() == '[' && s.charAt(i) == ']')
                    st.pop();
                else if(st.peek() == '[' && s.charAt(i) != ']')
                    st.add(s.charAt(i));
                else if(st.peek() == '(' && s.charAt(i) == ')')
                    st.pop();
                else
                    st.add(s.charAt(i));
            }
        }
        if(st.size() == 0)
            answer++;
    }
}
