import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        String step1 = new_id.toLowerCase();
        
        String step2 = "";
        for(int i = 0; i<step1.length(); i++){
            if(('a' <= step1.charAt(i) &&  step1.charAt(i) <= 'z' ) || ('0' <= step1.charAt(i) &&  step1.charAt(i) <= '9' )|| step1.charAt(i) == '-' || step1.charAt(i) == '_' || step1.charAt(i) == '.'){
                step2 = step2 + step1.charAt(i);
            }
        }
        
        while(step2.contains("..")){
            step2 = step2.replace("..",".");
        }
        String step3 = step2;
       
        String step4 = step3;
        if(step4.length() >= 1 && step4.charAt(0) == '.'){
            step4 = step4.substring(1,step4.length());
        }
        if(step4.length() >= 1 && step4.charAt(step4.length()-1) == '.'){
            step4 = step4.substring(0,step4.length()-1);
        }

        String step5 = step4;
        if(step5.length() == 0){
            step5 = "a";
        }
        
        String step6 = step5;
        if(step6.length() >= 16){
            step6 = step6.substring(0,15);
            if(step6.charAt(14) == '.'){
                step6 = step6.substring(0,14);
            }
        }
        
        String step7 = step6;
        if(step7.length() <= 2){
            while(step7.length() < 3){
                step7 = step7 + step7.charAt(step7.length()-1);
            }
        }
        
        answer = step7;
        return answer;
    }
}
