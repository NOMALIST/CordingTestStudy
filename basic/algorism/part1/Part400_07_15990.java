package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_07_15990 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		long[][] arr = new long[100001][4];
		
		arr[1][1] = 1;
		
		arr[2][2] = 1;
		
		arr[3][1] = 1;
		arr[3][2] = 1;
		arr[3][3] = 1;
		
		for(int i=4; i<=100000; i++) {
			// +1 붙을 때
			arr[i][1] += (arr[i-1][2] + arr[i-1][3]) % 1000000009;
			// +2 붙을 때
			arr[i][2] += (arr[i-2][1] + arr[i-2][3]) % 1000000009;
			// +3 붙을 때
			arr[i][3] += (arr[i-3][1] + arr[i-3][2]) % 1000000009;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append((arr[N][1] + arr[N][2] + arr[N][3]) % 1000000009 + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
