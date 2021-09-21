import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        LinkedList<String> list = new LinkedList<String>();
        
        for(int i = 0; i< cities.length; i++){
            
            String s = cities[i].toLowerCase();
            
            if(cacheSize != 0){ 
                if(!list.contains(s) && list.size() < cacheSize){
                    list.addFirst(s);
                    answer += 5;
                }else if(list.contains(s) && list.size() < cacheSize){
                    int index = 0;
                    for(int j = 0; j<list.size(); j++){
                        if(list.get(j).equals(s)){
                            index = j;
                            break;
                        }
                    }
                    list.remove(index);
                    list.addFirst(s);
                    answer++;
                }else if(!list.contains(s) && list.size() == cacheSize){
                    list.remove(list.size()-1);
                    list.addFirst(s);
                    answer+=5;
                }else{
                    int index = 0;
                    for(int j = 0; j<list.size(); j++){
                        if(list.get(j).equals(s)){
                            index = j;
                            break;
                        }
                    }
                    list.remove(index);
                    list.addFirst(s);
                    answer++;
                }
                
            }else if(cacheSize == 0){
                answer+=5;
            }
        }   // end of for

        return answer;
    }
}
