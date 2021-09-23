package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Part600_05_2667 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		
		int n = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				if(str.charAt(j) == '1') {
					arr[i][j] = ++n;
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j] != 0) {
					int a = arr[i][j];
					int b;
					if(i < N - 1 && (b = arr[i + 1][j]) != 0) {
						arrList.get(a).add(b);
						arrList.get(b).add(a);
					}
					
					if(j < N - 1 && (b = arr[i][j + 1]) != 0) {
						arrList.get(a).add(b);
						arrList.get(b).add(a);
					}
				}
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int[] visited = new int[n + 1];
		int groupCnt = 0;
		
		for(int i=1; i<=n; i++) {
			if(visited[i] == 0) {
				int count = 1;
				
				Stack<Integer> stack = new Stack<Integer>();
				stack.push(i);
				visited[i] = ++groupCnt; 

				while(!stack.isEmpty()) {
					int now = stack.pop();

					for(int a : arrList.get(now)) {
						if(visited[a] == 0) {
							stack.push(a);
							visited[a] = groupCnt;
							count++;
						}
					}
				}
				
				ans.add(count);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(groupCnt + "\n");
		
		Collections.sort(ans);
		for(int a : ans) {
			sb.append(a + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
