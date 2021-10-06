package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_05_1149 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] cost = new int[N + 1][3];
		
		for(int i=1; i<=N; i++) {
			String[] in = br.readLine().split(" ");
			
			cost[i][0] = Integer.parseInt(in[0]);
			cost[i][1] = Integer.parseInt(in[1]);
			cost[i][2] = Integer.parseInt(in[2]);
		}
		
		int[][] dp = new int[N + 1][3];
		
		// 0은 R일 때
		// 1은 G일 때
		// 2는 B일 때
		for(int i=1; i<=N; i++) {
			
			// i번째에 R을 칠할 때
			if(dp[i - 1][1] > dp[i - 1][2]) dp[i][0] = dp[i - 1][2] + cost[i][0];
			else dp[i][0] = dp[i - 1][1] + cost[i][0];
			 
			// i번째에 G을 칠할 때
			if(dp[i - 1][0] > dp[i - 1][2]) dp[i][1] = dp[i - 1][2] + cost[i][1];
			else dp[i][1] = dp[i - 1][0] + cost[i][1];
			 
			// i번째에 B을 칠할 때
			if(dp[i - 1][0] > dp[i - 1][1]) dp[i][2] = dp[i - 1][1] + cost[i][2];
			else dp[i][2] = dp[i - 1][0] + cost[i][2];
		}
		
		int answer = 2100000000;

		for(int i=0; i<3; i++) {
			if(dp[N][i] < answer) answer = dp[N][i];
		}
		
		System.out.println(answer);
		br.close();
	}
}
