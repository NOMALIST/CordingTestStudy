package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_01_1463 {

	static Integer[] dp;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new Integer[N + 1];
		dp[0] = dp[1] = 0;
		int ans = func(N);
		System.out.println(ans);
		
	}
	
	static int func(int n) {
		
		if(dp[n] == null) {
			// 6으로 나눠지는 경우
			if(n % 6 == 0) {
				dp[n] = Math.min(func(n - 1), Math.min(func(n / 3), func(n / 2))) + 1;
			}
			// 3으로 나눠지는 경우
			else if(n % 3 == 0) {
				dp[n] = Math.min(func(n / 3), func(n - 1)) + 1;
			}
			// 2로 나눠지는 경우
			else if(n % 2 == 0) {
				dp[n] = Math.min(func(n / 2), func(n - 1)) + 1;
			} 
			// 2,3으로 나눠지지 않는 경우
			else {
				dp[n] = func(n - 1) + 1;
			}
		}
		
		return dp[n];
	}
}
