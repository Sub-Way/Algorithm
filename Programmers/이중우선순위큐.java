import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i<operations.length; i++){
            StringTokenizer str = new StringTokenizer(operations[i], " ");
            String head = str.nextToken();
            int n = Integer.parseInt(str.nextToken());
            
            if(head.equals("I"))
                list.add(n);
            else{
                if(n == 1 && list.size() > 0){ // 최대값 삭제
                    Collections.sort(list);
                    list.remove(list.size()-1);
                }else if(n == -1 && list.size() > 0){ // 최소값 삭제
                    Collections.sort(list);
                    list.remove(0);
                }
            }
        }
        
        Collections.sort(list);
        if(list.size() == 0){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0);
        }
            
        return answer;
    }
}
