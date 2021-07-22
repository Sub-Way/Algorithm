/*
    이미 주어진 배열 자체를 정렬하면 되기 때문에 우선순위큐나 리스트에 넣어서 정렬할 필요가 없다.
    오히려 시간이 시간복잡도가 증가한다!
    String.split(), Character.isDigit(), Comparator 익혀두기
*/

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        
        Arrays.sort(files, new Comparator<String>(){
           
            @Override
            public int compare(String o1, String o2){
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];
                
                int num1 = number(head1, o1);
                int num2 = number(head2, o2);
                
                if(head1.toLowerCase().compareTo(head2.toLowerCase()) > 0){
                    return 1;
                }else if(head1.toLowerCase().compareTo(head2.toLowerCase()) < 0){
                    return -1;
                }else{
                    if(num1 - num2 > 0){
                        return 1;
                    }else if(num1 - num2 < 0){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        
        return files;
    }
    
    static public int number(String head, String o){
        int start = head.length();
        
        String st = "";
        for(int i = start; i<o.length(); i++){
            if(Character.isDigit(o.charAt(i))){
                st += o.charAt(i);
            }else{
                break;
            }
        }
        
        return Integer.parseInt(st,10);
    }
    
}
