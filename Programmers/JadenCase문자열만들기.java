import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        
        if(s.charAt(0) >= 'a' && s.charAt(0) <= 'z'){
            sb.append(s.substring(0,1).toUpperCase());
        }else{
            sb.append(s.substring(0,1));
        }
        
        for(int i = 1; i<s.length(); i++){
            if(s.charAt(i-1) == ' ' && (s.charAt(i) >= 'a' && s.charAt(i) <='z')){
                sb.append(s.substring(i,i+1).toUpperCase());
            }else if(s.charAt(i-1) == ' ' && s.charAt(i) == ' '){
                sb.append(s.substring(i,i+1));
            }else if(s.charAt(i-1) != ' ' && (s.charAt(i) >= 'A' && s.charAt(i) <='Z')){
                sb.append(s.substring(i,i+1).toLowerCase());
            }else{
                sb.append(s.substring(i,i+1));
            }
        }
        
        answer = sb.toString();
        return answer ;
    }
}

