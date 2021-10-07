package step_bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class BFS_DFS_10_7562 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int[][] moves = {{1, 2}, {2, 1},
						{-1, 2}, {2, -1},
						{1, -2}, {-2, 1},
						{-1, -2}, {-2, -1}};
		
		while(T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			String[] in = br.readLine().split(" ");

			int[] start = new int[2];
			start[0] = Integer.parseInt(in[0]);
			start[1] = Integer.parseInt(in[1]);
			
			in = br.readLine().split(" ");
			int[] goal = new int[2];
			goal[0] = Integer.parseInt(in[0]);
			goal[1] = Integer.parseInt(in[1]);
			
			LinkedList<int[]> que = new LinkedList<>();
			int[][] visited = new int[N + 1][N + 1];
			visited[start[0]][start[1]] = 1;
			que.add(start);
			
			while(!que.isEmpty()) {
				int[] now = que.poll();
				
				if(goal[0] == now[0] && goal[1] == now[1]) {
					sb.append(visited[now[0]][now[1]] - 1 + "\n");
					break;
				}
				
				for(int[] move : moves) {
					int x = now[0] + move[0];
					int y = now[1] + move[1];
					
					if(x >= 0 && x < N && y >= 0 && y < N) {
						if(visited[x][y] == 0) {
							visited[x][y] = visited[now[0]][now[1]] + 1;
							int[] a = {x, y};
							que.add(a);
						}
					}
				}
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
