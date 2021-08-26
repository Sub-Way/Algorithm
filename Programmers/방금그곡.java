import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        
        String answer = "(None)";
        int max = -1;

        m = m.replaceAll("C#","c");
        m = m.replaceAll("D#","d");
        m = m.replaceAll("F#","f");
        m = m.replaceAll("G#","g");
        m = m.replaceAll("A#","a");
        
        for(int i = 0; i< musicinfos.length; i++){
            StringTokenizer st = new StringTokenizer(musicinfos[i], ",");
            String start = st.nextToken();
            String end = st.nextToken();
            String title = st.nextToken();
            String info = st.nextToken();
            
            String sHH = start.substring(0,2);
            String sMM = start.substring(3,5);
            String eHH = end.substring(0,2);
            String eMM = end.substring(3,5);
            int time = 0;
            
            if(Integer.parseInt(eMM) - Integer.parseInt(sMM) >= 0){
                int HH = Integer.parseInt(eHH) - Integer.parseInt(sHH);
                int MM = Integer.parseInt(eMM) - Integer.parseInt(sMM);
                time = HH * 60 + MM;
            }else{
                int HH = Integer.parseInt(eHH) - Integer.parseInt(sHH) - 1;
                int MM = 60 + Integer.parseInt(eMM) - Integer.parseInt(sMM);
                time = HH * 60 + MM;
            }
            
            String melody = "";
            
            info = info.replaceAll("C#","c");
            info = info.replaceAll("D#","d");
            info = info.replaceAll("F#","f");
            info = info.replaceAll("G#","g");
            info = info.replaceAll("A#","a");
            
            if(time > info.length()){
                while(melody.length() < time){
                    melody += info;
                }
            }
            else{
                for(int j = 0; j<time; j++){
                    melody += info.charAt(j%(info.length()));
                }    
            }
            
            if(melody.contains(m) && time > max){
                answer = title;
                max = time;
            }
        }

        return answer;
    }
}
