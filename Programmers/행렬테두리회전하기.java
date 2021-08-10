/*
    회전 시킬 때 Queue를 사용하면 간결하게 회전 가능!
*/

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] arr = new int[rows][columns];
        int v = 1;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                arr[i][j] = v++;
            }
        }
        
        for(int i = 0; i<queries.length; i++){
            ArrayList<Info> list = new ArrayList<Info>();
            ArrayList<Info> rotate = new ArrayList<Info>();
            int li = queries[i][0] - 1;
            int lj = queries[i][1] - 1;
            int ri = queries[i][2] - 1;
            int rj = queries[i][3] - 1;
            
            for(int j = lj; j< rj; j++){
                list.add(new Info(li,j));
                rotate.add(new Info(li,j));
            }
            for(int j = li; j< ri; j++){
                list.add(new Info(j,rj));
                rotate.add(new Info(j,rj));
            }
            for(int j = rj; j> lj; j--){
                list.add(new Info(ri,j));
                rotate.add(new Info(ri,j));
            }
            for(int j = ri; j> li; j--){
                list.add(new Info(j,lj));
                rotate.add(new Info(j,lj));
            }
            Info tail = new Info(rotate.get(rotate.size()-1).i,rotate.get(rotate.size()-1).j);
            rotate.add(0,tail);
            rotate.remove(rotate.size()-1);
            
            int min = Integer.MAX_VALUE;
            int head = arr[tail.i][tail.j];
            for(int t = list.size()-1; t >= 0; t--){
                arr[list.get(t).i][list.get(t).j] = arr[rotate.get(t).i][rotate.get(t).j];
                min = Math.min(min,arr[rotate.get(t).i][rotate.get(t).j]);
            }
            arr[li][lj] = head;
            min = Math.min(min,arr[li][lj]);
            answer[i] = min;
        }
        
        return answer;
    }
}

class Info{
    int i;
    int j;
    public Info(int i, int j){
        this.i = i;
        this.j = j;
    }
}
