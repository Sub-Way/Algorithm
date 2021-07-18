import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        ArrayList<String> list1 = new ArrayList<String>();
        
        for(int i = 0 ; i < str1.length()-1; i++){
            int flag = 0;
            String st = str1.substring(i,i+2);
            for(int j = 0; j < st.length(); j++){
                if(st.charAt(j) < 'a'|| st.charAt(j) > 'z'){
                    flag = -1;
                    break;
                }
                   
            }
            if(flag == 0)
                list1.add(st);
        }
        
        ArrayList<String> list2 = new ArrayList<String>();
        
        for(int i = 0 ; i < str2.length()-1; i++){
            int flag = 0;
            String st = str2.substring(i,i+2);
            for(int j = 0; j < st.length(); j++){
                if(st.charAt(j) < 'a'|| st.charAt(j) > 'z'){
                    flag = -1;
                    break;
                }      
            }
            if(flag == 0)
                list2.add(st);
        }
        
        ArrayList<String> inter = new ArrayList<String>();
        int cnt1 = list1.size();
        int cnt2 = list2.size();
        boolean[] check1 = new boolean[list1.size()];
        boolean[] check2 = new boolean[list2.size()];
        
 
        for(int i = 0; i < list1.size(); i++){
            for(int j = 0; j < list2.size(); j++){
                if(list1.get(i).equals(list2.get(j)) && !check1[i] && !check2[j]){
                    inter.add(list1.get(i));

                    check1[i] = true;
                    cnt1--;
                    check2[j] = true;
                    cnt2--;
                }
            }
        }
            
        if(inter.size() == 0 && inter.size() + cnt1 + cnt2 == 0){
            answer = 65536;
        }else{
             answer = (65536 *inter.size()) / (inter.size() + cnt1+ cnt2);
        }
        
        return answer;
    }
}
