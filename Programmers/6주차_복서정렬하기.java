import java.util.*;

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        
        ArrayList<Info> list = new ArrayList<Info>();
        
        for(int i = 0; i< weights.length; i++){
            double win = 0;
            double lose = 0;
            int cnt = 0;
            double rate = 0.0;
            for(int j = 0; j < head2head[i].length(); j++){
                if(i == j)
                    continue;
                else{
                    if(head2head[i].charAt(j) == 'W'){
                        win++;
                        if(weights[i] < weights[j])
                            cnt++;
                    }
                    else if(head2head[i].charAt(j) == 'L')
                        lose++;
                }
            }
            if(win+lose == 0)
                rate = 0;
            else
                rate = win/(win+lose) * 100;
            
            list.add(new Info(weights[i],rate,cnt,i+1));
        }
        
        Collections.sort(list,new Comparator<Info>(){
            @Override
            public int compare(Info o1, Info o2){
                if(o1.rate > o2.rate){
                    return -1;
                }else if(o1.rate == o2.rate){
                    if(o1.cnt > o2.cnt)
                        return -1;
                    else if(o1.cnt < o2.cnt)
                        return 1;
                    else{
                        if(o1.w > o2.w)
                            return -1;
                        else if(o1.w < o2.w)
                            return 1;
                        else{
                            if(o1.n > o2.n)
                                return 1;
                            else if(o1.n < o2.n)
                                return -1;
                            else
                                return 0;
                        }
                    }
                }else
                    return 1;
            }
        });
        
        int[] answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i).n;
        }
        
        return answer;
    }
}

class Info{
    int w;
    double rate;
    int cnt;
    int n;
    
    public Info(int w, double rate, int cnt, int n){
        this.w = w;
        this.rate = rate;
        this.cnt = cnt;
        this.n = n;
    }
}
