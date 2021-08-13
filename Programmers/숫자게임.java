/*
    https://programmers.co.kr/learn/courses/30/lessons/12987?language=java
*/

import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int j = 0;
        x:for(int i = 0; i < A.length - j; i++){
            if(A[i] < B[i+j])
                answer++;
            else{
                while(true){
                    j++;
                    if(i+j < A.length && A[i] < B[i+j]){
                        answer++;
                        break;
                    }
                    if(i+j == A.length){
                        break x;
                    }
                } 
            }
        }
        
        return answer;
    }
}
