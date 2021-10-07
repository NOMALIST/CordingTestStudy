package step_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BFS_DFS_07_7569 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int M = Integer.parseInt(str[0]);
		int N = Integer.parseInt(str[1]);
		int H = Integer.parseInt(str[2]);
		
		int[][][] tomato = new int[H + 1][N + 1][M + 1];
		LinkedList<int[]> que = new LinkedList<>();
		
		for(int i=1; i<=H; i++) {
			for(int j=1; j<=N; j++) {
				str = br.readLine().split(" ");
				for(int k=1; k<=M; k++) {
					tomato[i][j][k] = Integer.parseInt(str[k - 1]);

					if(tomato[i][j][k] == 1) {
						int[] a = {i, j, k, 1};
						que.add(a);
					}
				}
			}
		}
		
		int[][] nextby = {{1, 0, 0}, {-1, 0, 0},
						  {0, 1, 0}, {0, -1, 0},
						  {0, 0, 1}, {0, 0, -1}};
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int[] next: nextby) {
				int h = now[0] + next[0];
				int n = now[1] + next[1];
				int m = now[2] + next[2];
				int count = now[3];
				
				if(h >= 1 && h <= H && m >= 1 && m <= M && n >= 1 && n <= N) {
					if(tomato[h][n][m] == 0) {
						int[] a = {h, n, m, count + 1};
						que.add(a);
						tomato[h][n][m] = count + 1;
					}
				}
			}
		}
		
		int answer = 0;
		for(int i=1; i<=H && answer != -1; i++) {
			for(int j=1; j<=N && answer != -1; j++) {
				for(int k=1; k<=M && answer != -1; k++) {
					if(tomato[i][j][k] == 0) {
						answer = -1;
						break;
					}
					
					if(tomato[i][j][k] != -1 && answer < tomato[i][j][k]) {
						answer = tomato[i][j][k];
					}
				}
			}
		}
		
		if(answer == -1) System.out.println(-1);
		else System.out.println(answer - 1);
		br.close();
	}
}
