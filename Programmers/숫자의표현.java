class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int k = (n%2 == 0) ? n/2 :n/2 + 1;
        
        for(int i = 1; i<k; i++){
            int sum = 0;
            int t = i;
            while(true){
                sum += t++;
                if(sum == n){
                    answer++;
                    break;
                }
                else if(sum > n)
                    break;
            }
        }
        
        answer++;
        return answer;
    }
}
