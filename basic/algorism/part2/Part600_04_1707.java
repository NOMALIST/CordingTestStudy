package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Part600_04_1707 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(K-- > 0) {
			
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
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
			
			boolean isDevide = bfs(arrList, N);
			
			if(isDevide) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	public static boolean bfs(ArrayList<ArrayList<Integer>> arrList, int N) {
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		int[] visited = new int[N + 1];
		
		for(int i=1; i<=N; i++) {
			if(visited[i] == 0) {
				que.push(i);
				visited[i] = 1;
				
				while(!que.isEmpty()) {
					int now = que.pop();
					int part = visited[now];
					for(int a : arrList.get(now)) {
						if(visited[a] != 0) {
							if(visited[a] == part) {
								return false;
							}
						} else {
							que.push(a);
							visited[a] = (part % 2) + 1;
						}
					}
				}							
			}
		}
				
		return true;
	}
}
