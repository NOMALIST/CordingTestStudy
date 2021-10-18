package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking_02_15650 {

	static int[] selected;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		
		selected = new int[K];
		visited = new boolean[N + 1];
		
		dfs(1, N, 0, K);
		
		System.out.println(sb);
		br.close();
		
	}
	
	public static void dfs(int start, int end, int selectN, int K) {
		if(selectN == K) {
			for(int a : selected) {
				sb.append(a + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=start; i<=end; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[selectN] = i;
				dfs(i + 1, end, selectN + 1, K);
				visited[i] = false;
			}
		}
	}
}
