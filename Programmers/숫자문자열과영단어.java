/*
     replaceAll을 활용하면
     더 쉽게 해결 가능한 문제!
*/

import java.util.*;

class Solution {
    public int solution(String s) {

        String[][] arr = {{"0","zero"},{"1","one"},{"2","two"},{"3","three"},{"4","four"},{"5","five"},{"6","six"},{"7","seven"},{"8","eight"},{"9","nine"}};
        
        StringBuilder sb = new StringBuilder();
        String st = "";
        
        for(int i = 0; i < s.length(); i++){       
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                st += s.charAt(i);
                for(int j = 0; j<10; j++){
                    if(st.equals(arr[j][1])){
                        sb.append(arr[j][0]);
                        st = "";
                        break;
                    }
                }
            }
            
            else{
                sb.append(s.charAt(i));
            }
            
        }
        
        int answer = (sb.toString().equals("")) ? Integer.parseInt(s) : Integer.parseInt(sb.toString());
        return answer;
    }
}
