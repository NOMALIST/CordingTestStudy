package step_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BFS_DFS_04_1012 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			String[] in = br.readLine().split(" ");
			
			int M = Integer.parseInt(in[0]);
			int N = Integer.parseInt(in[1]);
			int K = Integer.parseInt(in[2]);
			
			// true면 배추가 있음, false면 배추가 없음
			boolean[][] land = new boolean[N + 1][M + 1];
			
			for(int i=1; i<=K; i++) {
				in = br.readLine().split(" ");
				int a = Integer.parseInt(in[0]);
				int b = Integer.parseInt(in[1]);
				
				land[b+1][a+1] = true;
			}
			
			// true면 방문했음, false면 방문 안함
			boolean[][] visited = new boolean[N + 1][M + 1];
			int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
			int ans = 0;
			
			LinkedList<int[]> que = new LinkedList<int[]>();
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=M; j++) {
					if(land[i][j] && !visited[i][j]) {
						ans++;
						int[] xy = {i, j};
						que.offer(xy);
						visited[i][j] = true;
						
						while(!que.isEmpty()) {
							int[] now = que.poll();
							int[] temp;
							for(int[] a : move) {
								int y = now[0] + a[0];
								int x = now[1] + a[1];
								if(1 <= y && y <= N && 1<= x && x <= M) {
									if(land[y][x] && !visited[y][x]) {
										temp = new int[2];
										temp[0] = y;
										temp[1] = x;
										que.offer(temp);
										visited[y][x] = true;
									}
								}
							}
						}
					}
				}
			}
			
			sb.append(ans + "\n");
		}
		
		System.out.println(sb);
		br.close();
		
	}
}
