class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        int round = 0;
        int cnt = 0;
        
        while(!s.equals("1")){
            String st = "";
            for(int i = 0; i<s.length(); i++){
                if(s.charAt(i) != '0'){
                    st += s.charAt(i);
                }else{
                    cnt++;
                }
            }
            int len = st.length();
            s = Integer.toString(len,2);
            round++;
        }
        answer[0] = round;
        answer[1] = cnt;
        
        return answer;
    }
}
