import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        
        if(s.length() == 1){
            return 1;
        }
        
        for(int i = 1; i<=s.length()/2; i++){
            StringBuilder sb = new StringBuilder();
            
            String head = "";
            String tail = "";
            int cnt = 1;
            
            head = s.substring(0,i);
            
            for(int j = i; j<s.length(); j++){
                
                tail += s.charAt(j);
                
                if(((j+1)%i) == 0){
                    if(head.equals(tail)){
                        head = tail;
                        tail = "";
                        cnt++;   
                    }else{
                        if(cnt == 1){
                            sb.append(head);
                            head = tail;
                            tail = "";
                        }else{
                            sb.append(cnt).append(head);
                            head = tail;
                            tail = "";
                            cnt = 1;
                        }
                    }
                }
                
                if(j == s.length()-1){
                    if(head.equals(tail)){
                        cnt++;
                        sb.append(cnt).append(head);
                    }else{
                        if(cnt == 1){
                            sb.append(head).append(tail);
                        }else{
                            sb.append(cnt).append(head).append(tail);
                        }
                    }
                } 
            }
           
            answer = Math.min(answer,sb.toString().length());
        }
    
        return answer;
    }
}
