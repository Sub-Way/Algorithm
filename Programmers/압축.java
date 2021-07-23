import java.util.*;

class Solution {
    public int[] solution(String msg) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        char[] dic = new char[26];
        
        for(int i = 0; i < 26; i++){
            dic[i] = (char)(65+i);
            String s = "";
            s += dic[i];
            map.put(s,i+1);
        }
        
        int index = 0;
        String w = "";
        while(index < msg.length()){
            w += msg.charAt(index);
            index++;
            if(!map.containsKey(w)){
                list.add(map.get(w.substring(0,w.length()-1)));
                map.put(w, map.size()+1);
                msg = msg.substring(index-1, msg.length());
                index = 0;
                w = "";
            }
        }
        
        if(map.containsKey(w)){
            list.add(map.get(msg));
        }
        
        int[] answer = new int[list.size()];             
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
