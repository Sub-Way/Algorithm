import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = triangle[0][0];
        int n = triangle.length;

        for(int i = 1; i<n; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j == 0){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j];
                    answer = Math.max(answer, triangle[i][j]);
                }
                else if(j == triangle[i].length-1){
                    triangle[i][j] = triangle[i][j] + triangle[i-1][j-1];
                    answer = Math.max(answer, triangle[i][j]);
                }
                else{
                    triangle[i][j] = Math.max(triangle[i][j] + triangle[i-1][j-1], triangle[i][j] + triangle[i-1][j]);
                    answer = Math.max(answer, triangle[i][j]);
                }
            }
        }
        
        return answer;
    }
}
