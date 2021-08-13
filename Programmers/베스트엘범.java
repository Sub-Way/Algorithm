/*
    https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
*/

import java.util.*;

class Solution {
    static ArrayList<Info> temp;
    
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> genre = new HashMap<String, Integer>();
        
        for(int i = 0; i<genres.length; i++){
            if(!genre.containsKey(genres[i])){
                genre.put(genres[i],plays[i]);
            }else{
                genre.put(genres[i],genre.get(genres[i])+plays[i]);
            }
        }
        
        ArrayList<Info> list = new ArrayList<Info>();
        for(String st : genre.keySet()){
            list.add(new Info(st,genre.get(st)));
        }
        
        Collections.sort(list, new Comparator<Info>(){
            @Override
            public int compare(Info o1, Info o2){
                if(o1.play > o2.play){
                    return -1;
                }else if(o1.play < o2.play){
                    return 1; 
                }else
                    return 0;
            }
        });
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<list.size(); i++){
            String st = list.get(i).genre;
            ArrayList<Info> temp = new ArrayList<Info>();
            for(int j = 0; j< genres.length; j++){
                if(st.equals(genres[j])){
                    temp.add(new Info(plays[j],j));
                }
            }
            
           Collections.sort(temp, new Comparator<Info>(){
            @Override
            public int compare(Info o1, Info o2){
                if(o1.play > o2.play){
                    return 1;
                }else if(o1.play < o2.play){
                        return -1; 
                }else{
                    if(o1.index > o2.index)
                        return -1;
                    else if(o1.index > o2.index)
                        return 1;
                    else
                        return 0;
                }
            }
        });
            
            int t = 0;
            for(int j = temp.size()-1; j>=0; j--){
                t++;
                if(temp.size() > 2){
                    result.add(temp.get(j).index);
                    if(t==2)
                        break;
                }else{
                    result.add(temp.get(j).index);
                }
            }
        }
        
        int[] answer = new int[result.size()];
        for(int i = 0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
}

class Info{
    String genre;
    int play;
    int index;
    
    public Info(String genre, int play){
        this.genre = genre;
        this.play = play;
    }
    
    public Info(int play,int index){
        this.play = play;
        this.index = index;
    }
}
