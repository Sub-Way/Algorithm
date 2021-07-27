import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
                
        for(int i = 0; i<numbers.length; i++){
            String s = Long.toString(numbers[i],2);
            long n = numbers[i];
            
            if(n%2 == 0){ // 짝수일 때
                String st = s.substring(0,s.length()-1) + "1";
                answer[i] = Long.parseLong(st,2);
            } else{ //홀수일 때
                StringBuilder sb = new StringBuilder();
                int flag = 0;
                int index = 0;
                for(int j = s.length()-1; j>=0; j--){
                    if(s.charAt(j) == '0'){
                        flag = 1;
                        index = j;
                        break;
                    }
                }
                
                if(flag == 1){ // 1로 모두 안채워져있는 경우
                    sb.append(s);
                    sb.setCharAt(index,'1');
                    sb.setCharAt(index+1,'0');
                    answer[i] = Long.parseLong(sb.toString(),2);
                }else{ // 1로 모두 채워져있어서 맨 앞에 0 추가
                    sb.append("0").append(s);
                    sb.setCharAt(0,'1');
                    sb.setCharAt(1,'0');
                    answer[i] = Long.parseLong(sb.toString(),2);
                }
            }
            
        }

        return answer;
    }
}
