/*
    Integer.bitCount() 활용해보기
*/

import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String s = Integer.toString(n,2);
        int cnt = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '1')
                cnt++;
        }
        
        while(true){
            int temp = ++n;
            
            String st = Integer.toString(n,2);
            
            int t = 0;
            for(int i = 0; i<st.length(); i++){
                if(st.charAt(i) == '1')
                    t++;
            }
            
            if(t==cnt){
                answer = temp;
                break;
            }
        }
        
        return answer;
    }
}
