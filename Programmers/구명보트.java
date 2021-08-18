/*
    최대 무게로 태우기 위해선 가장 가벼운 사람 + 가장 무거운 사람 = 최대값이 되도록!
*/

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        int right = people.length - 1;
        int left = 0;
        
        while(right >= left){
            if(people[right] + people[left] > limit){
                right--;
                answer++;
            }else{
                right--;
                left++;
                answer++;
            }
        }

        return answer;
    }
}
