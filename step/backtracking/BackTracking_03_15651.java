package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking_03_15651 {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int K;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		N = Integer.parseInt(in[0]);
		K = Integer.parseInt(in[1]);
		
		arr = new int[K];
		dfs(0);
		
		System.out.println(sb);
		br.close();
	}
	
	public static void dfs(int selectN) {
		if(selectN == K) {
			for(int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			arr[selectN] = i;
			dfs(selectN + 1);
		}
	}
}
