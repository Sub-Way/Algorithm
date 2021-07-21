class Solution {
    public String solution(int n, int t, int m, int p) {
        
        String answer = "";
        String s = "";
        String temp = "";
        int cnt = 0;
        int index = 0;
        
        while(true){
            s += Integer.toString(cnt,n);
            cnt++;
            if(s.length() > (p-1) + (m*index)){
                temp += s.charAt((p-1) + (m*index));
                index++;
            }
            
            if(temp.length() == t)
                break;
        }
        
        answer = temp.toUpperCase();
        return answer;
    }
}
