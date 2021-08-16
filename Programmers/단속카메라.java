import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        PriorityQueue<info> pq = new PriorityQueue<info>(new Comparator<info>() {

			@Override
			public int compare(info o1, info o2) {
				return o1.e-o2.e;
			}
		});
        
        for(int i = 0; i< routes.length; i++){
            pq.add(new info(routes[i][0], routes[i][1]));
        }
        
		int temp = pq.peek().e;
		answer++;
		pq.poll();
		
		while (!pq.isEmpty()) {
			if(temp < pq.peek().s) {
				temp = pq.peek().e;
				answer++;
				pq.poll();
			}
			else
				pq.poll();
		} // end of while

        return answer;
    }
}

class info {
	int s;
	int e;
	
	info(int s, int e) {
		this.s = s;
		this.e = e;
	}
}
