package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Part600_08_7576 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int M = Integer.parseInt(in[0]);
		int N = Integer.parseInt(in[1]);
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		int[][] arr = new int[N][M];
		
		int[] visited = new int[N*M + 1];
		
		for(int i=0; i<=N*M; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++) {
			in = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				int tomato = arr[i][j];
				
				if(tomato == -1) {
					visited[i*M + j + 1] = -1;
					continue;
				}
				
				if(tomato == 1) {
					que.offer(i*M + j + 1);
					visited[i*M + j + 1] = 1;
				}
				
				int a = i*M + j + 1;
				if(i < N - 1 && arr[i + 1][j] != -1) {
					int b = a + M;
					arrList.get(a).add(b);
					arrList.get(b).add(a);
				}
				
				if(j < M - 1 && arr[i][j + 1] != -1) {
					int b = a + 1;
					arrList.get(a).add(b);
					arrList.get(b).add(a);
				}
			}
		}
		
		int max = 1;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			for(int a : arrList.get(now)) {
				if(visited[a] == 0) {
					visited[a] = visited[now] + 1;
					que.offer(a);
					max = visited[a];
				}
			}
		}
		
		boolean isFail = false;
		for(int i=1; i<=N*M; i++) {
			if(visited[i] == 0) {
				isFail = true;
				break;
			}
		}
		
		if(isFail) System.out.println(-1);
		else System.out.println(max - 1);
		br.close();
		
	}
}
