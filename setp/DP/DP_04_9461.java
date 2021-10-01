package setp.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_04_9461 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		long[] arr = new long[101];
		
		arr[1] = arr[2] = arr[3] = 1;
		arr[4] = arr[5] = 2;
		
		for(int i=6; i<=100; i++) {
			arr[i] = arr[i-1] + arr[i-5];
		}
		
		StringBuilder sb = new StringBuilder();
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			sb.append(arr[N] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
