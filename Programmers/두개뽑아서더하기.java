import java.util.*;

class Solution {
    static int[] arr = new int[2];
    static HashSet<Integer> set = new HashSet<Integer>();
    public int[] solution(int[] numbers) {
        
        mix(numbers,0,0);
        
        int[] answer = new int[set.size()];
        
        int i = 0;
        for(int x : set){
            answer[i++] = x;
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    static public void mix(int[] numbers, int index, int sp){
        if(index == arr.length){
            int sum = arr[0] + arr[1];
            set.add(sum);
        }else if(sp >= numbers.length){
            return;
        }else{
            arr[index] = numbers[sp];
            mix(numbers,index+1,sp+1);
            mix(numbers,index,sp+1);
        }
    }
    
}
