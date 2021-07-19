import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        int index = -1;
        for(int i = 0; i<dartResult.length(); i++){
            if(dartResult.charAt(i) == 'S'){
                int n = Integer.parseInt(dartResult.substring(index+1,i));
                index = i;
                list.add(n);
            }else if(dartResult.charAt(i) == 'D'){
                int n = Integer.parseInt(dartResult.substring(index+1,i));
                n = (int)Math.pow(n,2);
                index = i;
                list.add(n);
            }else if(dartResult.charAt(i) == 'T'){
                int n = Integer.parseInt(dartResult.substring(index+1,i));
                n = (int)Math.pow(n,3);
                index = i;
                list.add(n);
            }else if(dartResult.charAt(i) == '#'){
                int temp = list.get(list.size()-1);
                list.remove(list.size()-1);
                list.add(temp*(-1));
                index = i;
            }else if(dartResult.charAt(i) == '*'){
                if(list.size()<=1){
                    int temp = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    list.add(temp*2);
                }else{
                    int temp1 = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    int temp2 = list.get(list.size()-1);
                    list.remove(list.size()-1);
                    list.add(temp2*2);
                    list.add(temp1*2);
                }
                index = i;
            }
        }
        
        System.out.println(list);
        for(int i = 0; i<list.size(); i++){
            answer += list.get(i);
        }
        
        return answer;
    }
}
