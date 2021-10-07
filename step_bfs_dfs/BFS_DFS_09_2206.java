package step_bfs_dfs;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;

public class BFS_DFS_09_2206 {

	static int[][] field;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int N = Integer.parseInt(in[0]);
		int M = Integer.parseInt(in[1]);
		
		field = new int[N + 1][M + 1];
		
		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			
			for(int j=0; j<M; j++) {
				char a = str.charAt(j);
				
				if(a == '1') {
					field[i][j + 1] = 1;
				}
			}
		}
		
		int result = bfs(N, M);
		
		
		System.out.println(result);
		br.close();
	}
	
	static int bfs(int N, int M) {
		
		int[][][] visited = new int[N + 1][M + 1][2];
		
		visited[1][1][0] = 1;
		LinkedList<int[]> que = new LinkedList<int[]>();
		int[] a = {1, 1, 0};
		que.add(a);
		
		int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int[] m : move) {
				int y = now[0] + m[0];
				int x = now[1] + m[1];
				
				if(x >= 1 && x <= M && y >= 1 && y <= N) {
					if(field[y][x] == 1) {
						if(now[2] == 0) {
							visited[y][x][1] = visited[now[0]][now[1]][0] + 1;
							int[] temp = {y, x, 1};
							que.add(temp);							
						}
					} else {
						if(visited[y][x][now[2]] == 0) {
							visited[y][x][now[2]] = visited[now[0]][now[1]][now[2]] + 1;
							int[] temp = {y, x, now[2]};
							que.add(temp);
						}
					}
				}
			}
		}

		if(visited[N][M][0] == 0 && visited[N][M][1] == 0) return -1;
		else if(visited[N][M][0] == 0) return visited[N][M][1];
		else if(visited[N][M][1] == 0) return visited[N][M][0];
		else return Math.min(visited[N][M][0], visited[N][M][1]);
	}
}
