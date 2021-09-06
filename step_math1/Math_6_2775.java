package step_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Math_6_2775 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int[15][15];
		
		for(int i=1; i<=14; i++) {
			arr[0][i] = i;
		}
		
		for(int i=1;i<=14;i++) {
			arr[i][1] = 1;
			for(int j=2; j<=14; j++) {
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		int k, n;
		for(int i=1; i<=t; i++) {
			k = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());
			
			bw.write(String.valueOf(arr[k][n]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
