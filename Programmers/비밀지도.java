import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] st1 = new String[n];
        String[] st2 = new String[n];

        for(int i = 0; i<arr1.length; i++){
            StringBuilder sb = new StringBuilder();
            String bin = Integer.toString(arr1[i],2);
            for(int j = 0; j < n-bin.length(); j++){
                sb.append("0");
            }
            sb.append(bin);
            st1[i] = sb.toString();
        }

         for(int i = 0; i<arr2.length; i++){
            StringBuilder sb = new StringBuilder();
            String bin = Integer.toString(arr2[i],2);
            for(int j = 0; j < n-bin.length(); j++){
                sb.append("0");
            }
            sb.append(bin);
            st2[i] = sb.toString();
        }

        for(int i = 0; i<n; i++){
            String s = "";
            for(int j = 0; j<st1.length; j++){
                if(st1[i].charAt(j) == '0' && st2[i].charAt(j) == '0'){
                    s += " ";
                }else{
                    s += "#";
                }
            }
            answer[i] = s;
        }

        return answer;
    }
}
