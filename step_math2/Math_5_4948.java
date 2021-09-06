package step_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math_5_4948 {

	public static boolean[] checked = new boolean[123456*2+1];
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		findPrime();	// 소수찾기 메서드
		
		int n, count;
		StringBuilder sb = new StringBuilder();
		while((n = Integer.parseInt(br.readLine())) != 0) {
			count = 0;
			for(int i=n+1; i<=n*2; i++) {
				if(!checked[i]) {
					count++;
				}
			}
			sb.append(count + "\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void findPrime() {
		int n = 123456*2;
		checked[0] = checked[1] = true;
		for(int i=2; i <= Math.sqrt(n); i++) {
			if(!checked[i]) {
				for(int j=i*i; j<=n; j+=i) {
					checked[j] = true;
				}
			}
		}
	}
}
