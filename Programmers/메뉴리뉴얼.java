/*
    원본을 함부러 건들지 말자!
    복사본을 만들어서 사용하자
*/
import java.util.*;

class Solution {
    static ArrayList<String> list= new ArrayList<String>();
    static HashMap<String, Integer> map = new HashMap<>();
    static char[] st;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        for(int i = 0; i < course.length; i++){
            for(int j = 0; j<orders.length; j++){
                if(course[i] <= orders[j].length()){
                    st = new char[course[i]];
                    search(orders[j], 0, 0, course[i]);
                }
            }
        }
        
        for(int i = 0; i<course.length; i++){
            ArrayList<String> temp = new ArrayList<String>();
            int cnt = -1;
            for(String key : map.keySet()){
                if(map.get(key) >= 2 && course[i] == key.length()){
                    if(map.get(key) > cnt){
                        cnt = map.get(key);
                        temp = new ArrayList<String>();
                        temp.add(key);
                    }else if(map.get(key) == cnt){
                        temp.add(key);
                    }
                }
            }
            for(int j = 0; j<temp.size(); j++){
                list.add(temp.get(j));
            }
        }
        
        System.out.println(list);
        answer = new String[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
    
    static public void search(String s, int index, int sp, int len){
        if(index == len){

        char[] temp = new char[st.length];
        for(int i = 0; i < st.length; i++){
            temp[i] += st[i];
        }
            
        String str = "";
        Arrays.sort(temp);
            
        for(int i = 0; i < st.length; i++){
            str += temp[i];
        }
        if(!map.containsKey(str)){
            map.put(str,1);
        }else{
            map.put(str,map.get(str)+1);
        }
            
        }else if(sp >= s.length()){
            return;
            
        }else{
            st[index] = s.charAt(sp);
            search(s, index+1, sp+1, len);
            search(s, index, sp+1, len); 
        }
    }
}
