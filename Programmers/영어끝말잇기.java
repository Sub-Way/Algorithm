import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set = new HashSet<String>();
        set.add(words[0]);
        for(int i = 1; i<words.length; i++){
            
            if(set.contains(words[i])){
                if((i+1)%n == 0){
                    answer[0] = n;
                }else{
                    answer[0] = (i+1)%n;
                }
                
                answer[1] = (i/n) + 1;
                break;
            }
            
            else{
                set.add(words[i]);
            }
            
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                if((i+1)%n == 0){
                    answer[0] = n;
                }else{
                    answer[0] = (i+1)%n;
                }
                answer[1] = (i/n) + 1;
                break;
            }
        }

        return answer;
    }
}
