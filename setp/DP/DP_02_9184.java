package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_02_9184 {
	static int[][][] arr = new int[21][21][21];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringBuilder sb = new StringBuilder();
		while(true) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			
			if(a == -1 && b == -1 && c == -1) break;
			
			int result = func(a, b, c);
			
			sb.append("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static int func(int a, int b, int c) {
		
		if(a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if(a > 20 || b > 20 || c > 20) {
			return func(20, 20, 20);
		}
		
		if(arr[a][b][c] != 0) {
			return arr[a][b][c];
		}
		
		if(a < b && b < c) {
			arr[a][b][c] = func(a, b, c-1) + func(a, b-1, c-1) - func(a, b-1, c);
			return arr[a][b][c];
		}
		
		arr[a][b][c] = func(a-1, b, c) + func(a-1, b-1, c) + func(a-1, b, c-1) - func(a-1, b-1, c-1);
		return arr[a][b][c];
	}
}
