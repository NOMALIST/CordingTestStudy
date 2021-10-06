package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_12_11054 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str = br.readLine().split(" ");
		int[] input = new int[N + 1];
		for(int i=1; i<=N; i++) {
			input[i] = Integer.parseInt(str[i - 1]);
		}
		
		int[] count1 = new int[N + 1];
		for(int i=1; i<=N; i++) {
			
			int max = 0;
			
			for(int j=i-1; j>=1; j--) {
				if(input[i] > input[j] && count1[j] > max) {
					max = count1[j];
				}
			}
			
			count1[i] = max + 1;
		}
		
		int[] count2 = new int[N + 1];		
		for(int i=N; i>=1; i--) {
			int max = 0;
			
			for(int j=i+1; j<=N; j++) {
				if(input[i] > input[j] && count2[j] > max) {
					max = count2[j];
				}
			}
			
			count2[i] = max + 1;
		}
		
		int answer = -1;
		for(int i=1; i<=N; i++) {
			if(count1[i] + count2[i] - 1 > answer) {
				answer = count1[i] + count2[i] - 1;
			}
		}
		
		System.out.println(answer);
		br.close();
	}
}
