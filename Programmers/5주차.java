import java.util.*;

class Solution {
    static char[] arr = {'A','E','I','O','U'};
    static HashSet<String> set = new HashSet<String>();
    
    public int solution(String word) {
        int answer = 0;    
        int n = (int)Math.pow(2,arr.length) - 1;
        
        for(int i = 1; i<=n; i++){
            ArrayList<Character> list = new ArrayList<Character>();
            for(int j = 0; j<arr.length; j++){
                if((i&(1<<j)) != 0){
                    list.add(arr[j]);
                }
            }
            //System.out.println(list);
            char[] c = new char[list.size()];
            permu(0, list, c);
        }
        
        Iterator<String> iter = set.iterator();
        ArrayList<String> alist = new ArrayList<String>();
        while(iter.hasNext()){
            alist.add(iter.next());
        }
        
        Collections.sort(alist);
        
        for(int i = 0; i<alist.size(); i++){
            if(alist.get(i).equals(word)){
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
    
    public static void permu(int index, ArrayList<Character> list, char[] c){
        if(index == list.size()){
            String s = "";
            for(char ch : c){
                s += ch;
            }
            set.add(s);
        }else{
            for(int i = 0; i<list.size(); i++){
                c[index] = list.get(i);
                permu(index+1,list,c);
            }
        }
    }
}
