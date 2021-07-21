import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        while(true){
            Arrays.sort(arr);
            ArrayList<Integer> index = new ArrayList<Integer>();
            int flag = 0;
            
            y:for(int i = 2; i<=arr[arr.length-1]; i++){
                for(int j = 0; j<arr.length; j++){
                    if(arr[j] > 1 && arr[j]%i == 0){
                        index.add(j);
                        flag++;
                    }
                }
                
                if(flag > 0){
                    list.add(i);
                    for(int j = 0; j< index.size(); j++){
                        arr[index.get(j)] = arr[index.get(j)]/i;
                    }
                    Arrays.sort(arr);
                    index = new ArrayList<Integer>();
                    flag = 0;
                    break y;                    
                }
            }
            int cnt = 0;
            for(int j = 0; j<arr.length; j++){
                if(arr[j] == 1)
                    cnt++;
            }
            if(cnt == arr.length)
                break;
        }
        
        for(int x : list){
            answer *= x;
        }
        
        return answer;
    }
}
