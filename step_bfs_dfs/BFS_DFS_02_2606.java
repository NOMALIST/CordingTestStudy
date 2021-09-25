package step_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class BFS_DFS_02_2606 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		String[] in;
		for(int i=1; i<=M; i++) {
			in = br.readLine().split(" ");
			int a = Integer.parseInt(in[0]);
			int b = Integer.parseInt(in[1]);
			
			arrList.get(a).add(b);
			arrList.get(b).add(a);
		}
		
		int[] visited = new int[N + 1];
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		
		que.offer(1);
		visited[1] = 1;
		int ans = 0;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int a : arrList.get(now)) {
				if(visited[a] == 0) {
					que.offer(a);
					visited[a] = 1;
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
