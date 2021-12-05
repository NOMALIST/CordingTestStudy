package boj.short_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Short_path_3197 {
	
	
	private static int[][] lake;
	private static int R, C;
	private static int[][] check;
	private static boolean[][] visitedSwan;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]); // Row
		C = Integer.parseInt(input[1]); // Column
		
		lake = new int[R][C];
		check = new int[R][C];
		visitedSwan = new boolean[R][C];
		
		int[][] swan = new int[2][2];
		int swanCount = 0;
		
		for(int i=0; i<R; i++) {
			String in = br.readLine();
			for(int j=0; j<C; j++) {
				// 물 0  얼음 1  백조 0
				char a = in.charAt(j);
				if(a == 'X') {
					lake[i][j] = 1;
				} else if(a == 'L') {
					lake[i][j] = 0;
					swan[swanCount][0] = i; 
					swan[swanCount][1] = j; 
					swanCount++;
				} 
			}
		}
		
		int days = 1;
		// 1. 물 인접 얼음 찾기
		Queue<int[]> nextMelting = findMeltingIce();
		// 2. 인접얼음 녹이기
		nextMelting = melting(nextMelting);
		// 3. 첫번째 백조로 BFS 돌아서 두번째 백조 찾기
		
		Queue<int[]> findSwanQue = new LinkedList<int[]>();
		findSwanQue.add(swan[0]);
		visitedSwan[swan[0][0]][swan[0][1]] = true;
		
		while(true) {
			findSwanQue = findSwan(findSwanQue, swan[1]);
			
			if(findSwanQue == null) {
				break;
			}
			
			// 4. 실패시 날짜 증가시키고 1번으로 회귀
			days++;
			nextMelting = melting(nextMelting);
		}
		
		System.out.println(days);
		
		br.close();
		
	}
	
	private static Queue<int[]> findSwan(Queue<int[]> que, int[] goal) {
		
		Queue<int[]> nextFindSwanQue = new LinkedList<int[]>();

		int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			for(int i=0; i<4; i++) {
				int r = now[0] + move[i][0];
				int c = now[1] + move[i][1];
				
				if(r >= 0 && r < R && c >= 0 && c < C) {
					if(!visitedSwan[r][c]) {
						if(lake[r][c] == 0) {
							if(goal[0] == r && goal[1] ==c) {
								return null;
							}						
							int[] temp = {r, c};
							que.add(temp);
							visitedSwan[r][c] = true;
						} else {
							int[] temp = {r, c};
							nextFindSwanQue.add(temp);
							visitedSwan[r][c] = true;
						}
					}
				}
			}
			
		}
		
		return nextFindSwanQue;
	}
	
	private static Queue<int[]> melting(Queue<int[]> que) {
		
		Queue<int[]> nextMelt = new LinkedList<int[]>();
		
		int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		
		while(!que.isEmpty()) {
			int[] now = que.poll();
			
			lake[now[0]][now[1]] = 0;
			
			for(int i=0; i<4; i++) {
				int r = now[0] + move[i][0];
				int c = now[1] + move[i][1];
				if(r >= 0 && r < R && c >= 0 && c < C) {
					if(lake[r][c] == 1 && check[r][c] == 0) {
						check[r][c] = 1;
						int[] temp = {r, c};
						nextMelt.add(temp);
					}
				}
			}
			
			
		}
		
		return nextMelt;
	}
	
	private static Queue<int[]> findMeltingIce() {
		
		Queue<int[]> nextWaterQue = new LinkedList<int[]>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(lake[i][j] == 0) {
					if(i-1 >= 0 && lake[i-1][j] == 1 && check[i-1][j] == 0) {
						int[] a = {i-1, j};
						check[i-1][j] = 1;
						nextWaterQue.add(a);
					}
					if(j-1 >= 0 && lake[i][j-1] == 1 && check[i][j-1] == 0) {
						int[] a = {i, j-1};
						check[i][j-1] = 1;
						nextWaterQue.add(a);
					}
					if(i+1 < R && lake[i+1][j] == 1 && check[i+1][j] == 0) {
						int[] a = {i+1, j};
						check[i+1][j] = 1;
						nextWaterQue.add(a);
					}
					if(j+1 < C && lake[i][j+1] == 1 && check[i][j+1] == 0) {
						int[] a = {i, j+1};
						check[i][j+1] = 1;
						nextWaterQue.add(a);
					}
				}
			}
		}
		
		return nextWaterQue;
	}
	
}
