package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_10_2156 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N + 1];
		
		for(int i=1; i<=N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N + 1][3];
		
		// [0]은 안마실 때
		// [1]은 1잔 마실때
		// [2]는 2잔 연속으로 마실때
		
		for(int i=1; i<=N; i++) {
			int max = -1;
			
			if(max < dp[i-1][0]) max = dp[i-1][0];
			if(max < dp[i-1][1]) max = dp[i-1][1];
			if(max < dp[i-1][2]) max = dp[i-1][2];
			
			dp[i][0] = max;
			
			dp[i][1] = dp[i - 1][0] + wine[i];
			dp[i][2] = dp[i - 1][1] + wine[i];
			
		}
		
		int answer = -1;
		if(answer < dp[N][0]) answer = dp[N][0];
		if(answer < dp[N][1]) answer = dp[N][1];
		if(answer < dp[N][2]) answer = dp[N][2];
		
		System.out.println(answer);
		br.close();
	}
}
