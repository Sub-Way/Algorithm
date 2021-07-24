/*
    정규표현식 공부해볼 것!
*/

import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = skill_trees.length;
        
        ArrayList<Info> list = new ArrayList<Info>();
        
        for(int i = 0; i<skill.length(); i++){
            list.add(new Info(skill.charAt(i),i+1));
        }
        
        for(int i = 0; i<skill_trees.length; i++){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for(int j = 0; j<skill_trees[i].length(); j++){
                for(int k = 0; k<list.size(); k++){
                    if(skill_trees[i].charAt(j) == list.get(k).c){
                        temp.add(list.get(k).i);
                    }
                }
            }
            
            for(int j = 0; j<temp.size(); j++){
                if(j==0 && temp.get(j) != 1){
                    answer--;
                    break;
                }else if(j > 0){
                    int prev = temp.get(j-1);
                    if(temp.get(j) - prev != 1){
                        answer--;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
    
}

class Info{
    char c;
    int i;
    
    public Info(char c, int i){
        this.c = c;
        this.i = i;
    }
}
