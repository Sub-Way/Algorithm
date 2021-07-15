import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
            
            @Override
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });
        
        s = s.substring(1,s.length()-1);
        s = s.replace("},{","} {");
        StringTokenizer st = new StringTokenizer(s, " ");
        
        while(st.hasMoreTokens()){
            pq.add(st.nextToken());
        }
        
       
        int[] answer = new int[pq.size()];
        HashSet<Integer> set = new HashSet<Integer>();
        
        int cnt = 0;
        while(!pq.isEmpty()){
            String tuple = pq.poll();
            tuple = tuple.substring(1,tuple.length()-1);
            st = new StringTokenizer(tuple, ",");
            
            while(st.hasMoreTokens()){
                int n = Integer.parseInt(st.nextToken());
                if(!set.contains(n)){
                    answer[cnt++] = n;
                    set.add(n);
                }
            }
        }

        return answer;
    }
}
