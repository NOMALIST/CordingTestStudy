package step_recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_3_2447 {

	public static boolean[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new boolean[n+1][n+1];
		
		func(1,1,n,n);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(arr[i][j]) {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
		br.close();
	}
	
	public static void func(int x1, int y1, int x2, int y2) {
		
		if(x1 == x2) {
			arr[x1][y1] = true;
			return;
		}
		
		int n = (x2 - x1 + 1) / 3;
		int n2 = n * 2;
		
		func(x1, y1, x1+n-1, y1+n-1);
		func(x1+n, y1, x1+n2-1, y1+n-1);
		func(x1+n2, y1, x2, y1+n-1);
		
		func(x1, y1+n, x1+n-1, y1+n2-1);
		func(x1+n2, y1+n, x2, y1+n2-1);
		
		func(x1, y1+n2, x1+n-1, y2);
		func(x1+n, y1+n2, x1+n2-1, y2);
		func(x1+n2, y1+n2, x2, y2);
	}
}
