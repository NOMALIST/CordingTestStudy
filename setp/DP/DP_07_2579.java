package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_07_2579 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] stair = new int[N + 1];
		
		for(int i=1; i<=N; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		int[][] dp = new int[N + 1][3];
		
		// [0] 현재 계단을 안밟을 때
		// [1] 현재 계단이 1번 연속일 때
		// [2] 현재 계단이 2번 연속일 때
		for(int i=1; i<=N; i++) {
			int max = -1;

			// [0] 값 판단
			if(dp[i - 1][1] > max) max = dp[i - 1][1];
			if(dp[i - 1][2] > max) max = dp[i - 1][2];
			
			dp[i][0] = max;
			
			// [1] 값 판단
			dp[i][1] = dp[i - 1][0] + stair[i];
			
			// [2] 값 판단
			dp[i][2] = dp[i - 1][1] + stair[i];
			
		}
		
		int answer = -1;
		if(dp[N][1] > answer) answer = dp[N][1];
		if(dp[N][2] > answer) answer = dp[N][2];
		
		System.out.println(answer);
		br.close();
	}
}
