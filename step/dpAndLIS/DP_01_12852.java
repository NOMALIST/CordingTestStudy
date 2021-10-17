package step.dpAndLIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_01_12852 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N + 1];
		int[] from = new int[N + 1];
		
		for(int i=2; i<=N; i++) {
			
			int case1 = dp[i - 1];
			
			int case2;
			if(i % 2 == 0) {
				case2 = dp[i/2];
			} else {
				case2 = 2100000000;
			}
			
			int case3;
			if(i % 3 == 0) {
				case3 = dp[i/3];
			} else {
				case3 = 2100000000;
			}
			
			if(case1 <= case2 && case1 <= case3) {
				dp[i] = dp[i - 1] + 1;
				from[i] = 1;
			} else if(case2 <= case1 && case2 <= case3) {
				dp[i] = dp[i / 2] + 1;
				from[i] = 2;
			} else {
				dp[i] = dp[i / 3] + 1;
				from[i] = 3;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(dp[N] + "\n");
		int n = N;
		while(true) {
			
			sb.append(n + " ");
			
			if(n == 1) break;
			
			if(from[n] == 1) {
				n -= 1;
			} else if(from[n] == 2) {
				n /= 2;
			} else {
				n /= 3;
			}
		}
		
		System.out.println(sb);
	}
}
