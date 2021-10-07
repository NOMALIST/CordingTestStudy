package step_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BFS_DFS_08_1697 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int me = Integer.parseInt(in[0]);
		int target = Integer.parseInt(in[1]);
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		
		que.add(me);
		int[] visited = new int[100001];
		visited[me] = 1;
		int answer = -1;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(now == target) {
				answer = visited[now];
				break;
			}
			
			int a = now - 1;
			if(a >= 0 && visited[a] == 0) {
				que.add(a);
				visited[a] = visited[now] + 1;
			}
			
			a = now + 1;
			if(a <= 100000 && visited[a] == 0) {
				que.add(a);
				visited[a] = visited[now] + 1;
			}
			
			a = now * 2;
			if(a <= 100000 && visited[a] == 0) {
				que.add(a);
				visited[a] = visited[now] + 1;
			}
		}
		
		System.out.println(answer - 1);
		br.close();
	}
}
