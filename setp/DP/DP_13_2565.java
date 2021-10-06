package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class DP_13_2565 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] line = new int[N + 1][2];
		for(int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			line[i][0] = Integer.parseInt(str[0]);
			line[i][1] = Integer.parseInt(str[1]);
		}
		
		Arrays.sort(line, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		
		
		int[] dp = new int[N + 1];
		
		for(int i=1; i<=N; i++) {
			
			int max = 0;
			for(int j=i-1; j>=1; j--) {
				if(line[i][1] > line[j][1] && dp[j] > max) {
					max = dp[j];
				}
			}
			
			dp[i] = max + 1;
		}
		
		int answer = -1;
		
		for(int i=N; i>=1; i--) {
			if(answer < dp[i]) answer = dp[i];
		}
		
		System.out.println(N - answer);
		br.close();
		
	}
}
