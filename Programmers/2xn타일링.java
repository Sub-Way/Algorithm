import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 2;
        
        if(n == 1){
            answer = arr[1];
        }else if(n == 2){
            answer = arr[2];
        }else{
            for(int i = 3; i<=n; i++){
                arr[i] = arr[i-1]%1000000007 + arr[i-2]%1000000007;
            }
        }
        answer = arr[n]%1000000007;
        return answer;
    }
}
