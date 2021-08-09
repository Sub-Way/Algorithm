/*
    문제 : https://programmers.co.kr/learn/courses/30/lessons/83201?language=java
    1. 더 간단하게 푸는 방법이 있음!(list, Info class, 정렬 필요 없음)
    2. 삼항 연산자 여러개로 if문 줄일 수 있음!
*/
import java.util.*;

class Solution {
    public String solution(int[][] scores) {
        
        StringBuilder sb = new StringBuilder();
        String answer = "";
        int row = scores.length;
        int col = scores[row-1].length;
        int myScore = 0;
        int myIndex = 0;
        
        for(int i = 0; i<col; i++){
            ArrayList<Info> list = new ArrayList<Info>();

            for(int j = 0; j<row; j++){
                list.add(new Info(scores[j][i],j));
                if(i == j){ // 자신에게 준 점수
                    myScore = scores[j][i];
                    myIndex = i;
                }
            }
            
            Collections.sort(list,new Comparator<Info>(){ // 점수 순으로 배열
                @Override
                public int compare(Info o1, Info o2) {
                    if(o1.score < o2.score)
                        return 1;
                    else if(o1.score > o2.score)
                        return -1;
                    else
                        return 0;
                }
            });
            
            int max = list.get(0).score; // 최고 점수
            int min = list.get(list.size()-1).score; // 최저 점수
            int sum = 0;
            ArrayList<Integer> maxList = new  ArrayList<Integer>();
            ArrayList<Integer> minList = new  ArrayList<Integer>();
            
            for(int t = 0; t<list.size(); t++){
                sum += list.get(t).score;
                if(list.get(t).score == max){
                    maxList.add(list.get(t).num);
                }else if(list.get(t).score == min){
                    minList.add(list.get(t).num);
                }
            }
            
            String s = "";
            if(!maxList.contains(myIndex) && !minList.contains(myIndex)){
                s = String.format("%.2f",(double)sum / list.size());
            }else if(maxList.contains(myIndex) && maxList.size() == 1){
                sum -= myScore;
                s = String.format("%.2f",(double)sum / (list.size() - 1));
            }else if(minList.contains(myIndex) && minList.size() == 1){
                sum -= myScore;
                s = String.format("%.2f",(double)sum / (list.size() - 1));
            }else if(maxList.contains(myIndex) && maxList.size() != 1){
                s = String.format("%.2f",(double)sum / list.size());
            }else if(minList.contains(myIndex) && minList.size() != 1){
                s = String.format("%.2f",(double)sum / list.size());
            }
            
            if(Double.parseDouble(s) >= 90){
                sb.append("A");
            }else if(Double.parseDouble(s) >= 80 && Double.parseDouble(s) < 90){
                sb.append("B");
            }else if(Double.parseDouble(s) >= 70 && Double.parseDouble(s) < 80){
                sb.append("C");
            }else if(Double.parseDouble(s) >= 50 && Double.parseDouble(s) < 70){
                sb.append("D");
            }else{
                sb.append("F");
            }
        }

        answer = sb.toString();
        return answer;
    }
}

class Info{
    int score;
    int num;
    
    public Info(int score, int num){
        this.score = score;
        this.num = num;
    }
}
