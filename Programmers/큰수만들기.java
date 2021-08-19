class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        int l = number.length()-k;
        while(l>0){
            int max = 0;
            for(int i = start; i<=number.length()-l; i++){
                if(max < number.charAt(i) - '0'){
                    max = number.charAt(i) - '0';
                    start = i+1;
                }
            }
            sb.append(max);
            l--;
        }
        answer = sb.toString();
        return answer;
    }
}
