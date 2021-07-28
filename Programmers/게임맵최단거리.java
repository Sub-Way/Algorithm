import java.util.*;

class Solution {
    static int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
    static boolean[][] check;
    
    public int solution(int[][] maps) {
        
        int answer = 0;
        check = new boolean[maps.length][maps[0].length];
        
        Queue<Info> q = new LinkedList<Info>();
        q.add(new Info(0,0,1));
        check[0][0] = true;
        
        while(!q.isEmpty()){
            Info head = q.poll();
            
            for(int d = 0; d<4; d++){
                int ni = head.i + dir[d][0];
                int nj = head.j + dir[d][1];
                
                if(isin(ni,nj,maps) && !check[ni][nj] && maps[ni][nj] != 0){
                    q.add(new Info(ni,nj,head.l+1));
                    check[ni][nj] = true;
                    maps[ni][nj] = head.l+1;
                }
            }
        }
        
        if(maps[maps.length-1][maps[0].length-1] == 1)
            answer = -1;
        else
            answer = maps[maps.length-1][maps[0].length-1];
        return answer;
    }
    
    static public boolean isin(int i, int j, int[][] maps){
        return 0<= i && i<maps.length && 0<=j && j<maps[0].length;
    }
}

class Info{
    int i;
    int j;
    int l;
    
    public Info(int i, int j, int l){
        this.i = i;
        this.j = j;
        this.l = l;
    }
}
