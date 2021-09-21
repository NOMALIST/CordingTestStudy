package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_08_10844 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long arr[][] = new long[N+1][10];
		
		for(int i=1; i<=9; i++) {
			arr[1][i] = 1;
		}
		
		for(int i=2; i<=N; i++) {
			arr[i][0] = arr[i-1][1];
			
			for(int j=1; j<=8; j++) {
				arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
			}
			
			arr[i][9] = arr[i-1][8];
		}
		
		long ans = 0;
		for(int i=0; i<=9; i++) {
			ans = (ans + arr[N][i]) % 1000000000;
		}
		
		System.out.println(ans);
		br.close();
	}
}
