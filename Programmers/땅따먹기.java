class Solution {
    int solution(int[][] land) {
        int answer = -1;
        int n = land.length;
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                if(j == 0)
                    land[i][j] = Math.max(land[i][j]+land[i-1][j+1] , Math.max(land[i][j]+land[i-1][j+2],land[i][j]+land[i-1][j+3]));
                else if(j == 1)
                    land[i][j] = Math.max(land[i][j]+land[i-1][j-1] , Math.max(land[i][j]+land[i-1][j+1],land[i][j]+land[i-1][j+2]));
                else if(j == 2)
                    land[i][j] = Math.max(land[i][j]+land[i-1][j-2] , Math.max(land[i][j]+land[i-1][j-1],land[i][j]+land[i-1][j+1]));
                else
                    land[i][j] = Math.max(land[i][j]+land[i-1][j-3] , Math.max(land[i][j]+land[i-1][j-2],land[i][j]+land[i-1][j-1]));
            }
            if(i == n-1)
                answer = Math.max(land[i][0],Math.max(land[i][1],Math.max(land[i][2],land[i][3])));
        }

        return answer;
    }
}
