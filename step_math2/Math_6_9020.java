package step_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math_6_9020 {

	public static boolean[] prime = new boolean[10001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		findPrime();	// 소수 찾기 메서드
		int n, ans;
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=t; i++) {
			n = Integer.parseInt(br.readLine());
			ans = -1;
			for(int j=n/2; j>=2; j--) {
				if(!prime[j]) {
					if(!prime[n-j]) {
						ans = j;
						break;
					}
				}
			}
			sb.append(ans + " " + (n-ans) + "\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void findPrime() {
		int n = 10000;
		prime[0] = prime[1] = true;
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(!prime[i]) {
				for(int j=i*i; j<=n; j+=i) {
					prime[j] = true;
				}
			}
		}
	}
}
