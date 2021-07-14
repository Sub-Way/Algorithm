import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_14719 {
	static int h,w;
	static int[] arr;
	static int sum;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	
		h =	Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		arr = new int[w];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= w-2; i++) {
			int leftMax=-1, rightMax=-1;
			
			for (int j = i-1; j >= 0; j--) {
				leftMax = Math.max(leftMax, arr[j]);
			}
			for (int j = i+1; j < w; j++) {
				rightMax = Math.max(rightMax,arr[j]);
			}
			
			int min = Math.min(leftMax,rightMax);
			if(min > arr[i]) {
				sum = sum + Math.abs(min - arr[i]);
			}
			
		}
		System.out.println(sum);
	} // end of main
} // end of main
