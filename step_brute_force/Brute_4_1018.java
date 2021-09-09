package step_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Brute_4_1018 {

	public static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		String str;
		
		for(int i=1; i<=n; i++) {
			str = br.readLine();
			for(int j=1; j<=m; j++) {
				char a = str.charAt(j-1);
				if(a == 'B') arr[i][j] = 1;
			}
		}
		
		
		int min = 9999999, a;
		
		for(int i=1; i<=n-8+1; i++) {
			for(int j=1; j<=m-8+1; j++) {
				a = func(i, j);
				if(a < min) min = a;
			}
		}
		
		System.out.println(min);
		br.close();
	}
	
	public static int func(int x, int y) {
	
		int countB = 0;	// 홀수번째 B, 짝수번째 W
		int countW = 0;	// 홀수번째 W, 짝수번째 B
		int white = 0;
		int black = 1;
		
		for(int i=x; i<x+8; i++) {
			for(int j=y; j<y+8; j++) {
				if( (i + j) % 2 == 1) {	// 홀수번째
					if(arr[i][j] == white) countB++;	// 홀수번째가 W일때  B로 색칠
					else countW++;	// 홀수번째가 B일때 W로 색칠
				} else {	// 짝수번째
					if(arr[i][j] == black) countB++;	// 짝수번째가 B일째 W로 색칠
					else countW++;	// 짝수번째가 W일때 B로 색칠
				}
			}
		}
		
		if(countB < countW) return countB;
		else return countW;
	}
}
