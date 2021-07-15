class Solution {
    public int solution(int n) {
        int answer = 0;
        
        String step1 = Integer.toString(n,3);
        
        StringBuilder sb = new StringBuilder();
        sb.append(step1);
        
        String step2= sb.reverse().toString();
        
        //answer = Integer.parseInt(step2,3);
        for(int i = 0; i<step2.length(); i++){
            answer += Integer.parseInt(step2.substring(i,i+1)) * Math.pow(3,step2.length()-(i+1));
        }

        return answer;
    }
}
