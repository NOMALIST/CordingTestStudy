package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Part600_02_1260 {

	public static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		int V = Integer.parseInt(input[2]);
		
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			arrList.get(a).add(b);
			arrList.get(b).add(a);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(arrList.get(i));
		}
		
		boolean[] visited = new boolean[N + 1];
		dfs(V, arrList, visited);
		sb.append("\n");
		visited = new boolean[N + 1];
		bfs(V, arrList, visited);
		
		System.out.println(sb);
		br.close();
		
	}
	
	public static void dfs(int now, ArrayList<ArrayList<Integer>> arrList, boolean[] visited) {
		
		visited[now] = true;
		sb.append(now + " ");
		
		for(int i : arrList.get(now)) {
			if(!visited[i]) {
				dfs(i, arrList, visited);
			}
		}
	}
	
	public static void bfs(int start, ArrayList<ArrayList<Integer>> arrList, boolean[] visited) {
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		
		que.add(start);
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			if(visited[now]) continue;
			else {
				visited[now] = true;
				sb.append(now + " ");
			}
			
			for(int i : arrList.get(now)) {
				if(!visited[i]) {
					que.add(i);
				}
			}
		}
	}
}
