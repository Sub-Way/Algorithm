import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        PriorityQueue<Info> pq = new PriorityQueue<Info>(new Comparator<Info>() {

			@Override
			public int compare(Info o1, Info o2) {
				if(o1.value < o2.value)
                    return 1;
                else if(o1.value > o2.value)
                    return -1;
                else{
                    if(o1.num < o2.num){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                    
			}
		});
        
        
        for(int i = 1; i <= N; i++){
            float total = 0;
            float pass = 0;
            for(int j = 0; j < stages.length; j++){
                if(stages[j] >= i){
                    total++;
                    if(stages[j] > i){
                        pass++;    
                    }
                }
            }
            pq.add(new Info(((total-pass)/total),i));    
        }
        
        int i = 0;
        while(pq.size() > 0){
           answer[i++] = pq.poll().num;
        }
       
        return answer;
    }
    static public class Info{
        double value;
        int num;
        
        public Info(double value, int num){
            this.value = value;
            this.num = num;
        }
    }
}

