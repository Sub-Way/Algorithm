import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int[] big = new int[sizes.length];
        int[] small = new int[sizes.length];
        
        for(int i = 0; i< sizes.length; i++){
            if(sizes[i][0] >= sizes[i][1]){
                big[i] = sizes[i][0];
                small[i] = sizes[i][1];
            }else{
                big[i] = sizes[i][1];
                small[i] = sizes[i][0];
            }       
        }
        
        Arrays.sort(big);
        Arrays.sort(small);
        
        answer = big[sizes.length-1] * small[sizes.length-1];

        return answer;
    }
}
