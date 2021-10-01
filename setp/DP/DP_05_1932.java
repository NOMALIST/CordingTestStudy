package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_05_1932 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] input = new int[N + 1][N + 1];
		int[][] max = new int[N + 1][N + 1];
		
		for(int i=1; i<=N; i++) {
			String[] str = br.readLine().split(" ");
			
			for(int j=0; j<i; j++) {
				input[i][j + 1] = Integer.parseInt(str[j]);
			}
		}
		
		for(int i=1; i<=N; i++) {
			max[N][i] = input[N][i];
		}
		
		for(int i=N-1; i>=1; i--) {
			for(int j=1; j<=i; j++) {
				if(max[i+1][j] > max[i+1][j+1]) {
					max[i][j] = input[i][j] + max[i+1][j];
				} else {
					max[i][j] = input[i][j] + max[i+1][j+1];
				}
			}
		}
		
		System.out.println(max[1][1]);
		br.close();
	}
}
