package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_16_12865 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		
		int[] weights = new int[N + 1];
		int[] values = new int[N + 1];
		for(int i=1; i<=N; i++) {
			in = br.readLine().split(" ");
			
			weights[i] = Integer.parseInt(in[0]);
			values[i] = Integer.parseInt(in[1]);
		}
		
		// dp[가방의 크기][넣을 물건 목록]
		int[][] dp = new int[K + 1][N + 1];
		
		for(int i=1; i<=K; i++) {	// i는 가방의 크기
			for(int j=1; j<=N; j++) {
				if(i >= weights[j]) {
					dp[i][j] = Math.max(dp[i - weights[j]][j - 1] + values[j], dp[i][j - 1]);
				} else {
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		
		System.out.println(dp[K][N]);
		br.close();
	}
}
