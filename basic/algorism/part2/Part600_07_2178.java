package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Part600_07_2178 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		int[][] arr = new int[N][M];
		int n = 0;
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				char a = str.charAt(j);
				if(a == '1') {
					arr[i][j] = ++n;
				}
			}
		}
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		for(int i=0; i<=n; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int a, b;
				if((a = arr[i][j]) != 0) {
					if(i + 1 < N && (b = arr[i + 1][j]) != 0) {
						arrList.get(a).add(b);
						arrList.get(b).add(a);
					}
					
					if(j + 1 < M && (b = arr[i][j + 1]) != 0) {
						arrList.get(a).add(b);
						arrList.get(b).add(a);
					}
				}
			}
		}
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		int[] visited = new int[n + 1];
		
		que.offer(1);
		visited[1] = 1;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int a : arrList.get(now)) {
				if(visited[a] == 0) {
					que.offer(a);
					visited[a] = visited[now] + 1;
				}
			}
		}
		
		System.out.println(visited[n]);
		br.close();
		
	}
}
