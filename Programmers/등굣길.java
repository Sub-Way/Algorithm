import java.util.*;

class Solution {
    static int answer = 0;
    static int[][] map;
    
    public int solution(int m, int n, int[][] puddles) {
    
        map = new int[n][m];
        map[0][0] = 1;
        
        for(int l = 0; l< puddles.length; l++){
            int i = puddles[l][1]-1;
            int j = puddles[l][0]-1;
            
            map[i][j] = -1;
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j]!= -1 && isin(i-1,j) && isin(i,j-1) && (map[i-1][j] != -1 && map[i][j-1] != -1)){
                    map[i][j] = map[i-1][j]%1000000007 + map[i][j-1]%1000000007;
                }else if(map[i][j]== 0 && !isin(i-1,j) && isin(i,j-1)){
                    map[i][j] = map[i][j-1];
                }else if(map[i][j]== 0 && isin(i-1,j) && !isin(i,j-1)){
                    map[i][j] = map[i-1][j];
                }else if(map[i][j]== 0 && isin(i-1,j) && isin(i,j-1) && map[i-1][j] == -1){
                    map[i][j] = map[i][j-1];
                }else if(map[i][j]== 0 && isin(i-1,j) && isin(i,j-1) && map[i][j-1] == -1){
                    map[i][j] = map[i-1][j];
                }
            }
        }
        
        answer = map[n-1][m-1]%1000000007 >= 0 ? map[n-1][m-1]%1000000007 : 0;
        return answer;
    }
    
    static public boolean isin(int i, int j){
        return 0<= i && i<map.length && 0<= j && j <map[i].length;
    }
}
