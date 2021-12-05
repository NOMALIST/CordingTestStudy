package programmers.skillcheck.level2;

import java.util.LinkedList;

public class Problem2 {
	
	private int[][] room;

	public int[] solution(String[][] places) {
		int[] answer = new int[5];
		
		for(int i=0; i<5; i++) {
			room = new int[5][5];
			matrix(places[i]);
			if(isDistance()) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
			System.out.println(answer[i]);
		}
		
		
	    return answer;
	}
	
	public void matrix(String[] roomString) {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				char a = roomString[i].charAt(j);
				// 1은 사람 ,	0은 빈테이블 ,	9는 파티션
				if(a == 'P') {
					room[i][j] = 1;
				} else if(a == '0') {
					room[i][j] = 0;
				} else {
					room[i][j] = 9;
				}
			}
		}
	}
	
	public boolean isDistance() {
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(room[i][j] == 1) {
					if(bfs(i, j) == true) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean bfs(int x, int y) {
		
		LinkedList<int[]> que = new LinkedList<int[]>();
		int[] first = {x, y};
		int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		int[][] check = new int[5][5];
		
		que.offer(first);
		check[x][y] = 1;
		
		while(!que.isEmpty()) {
			
			int[] now = que.poll();
			
			if(check[now[0]][now[1]] == 3) continue;
			
			for(int i=0; i<4; i++) {
				int x2 = now[0] + move[i][0];
				int y2 = now[1] + move[i][1];
				int depth = check[now[0]][now[1]];
				
				if(x2 >= 0 && x2 <5 && y2 >=0 && y2 <5) {
					if(room[x2][y2] == 0 && check[x2][y2] == 0) {
						int[] go = {x2, y2};
						que.offer(go);
						check[x2][y2] = depth + 1;
					} else if(room[x2][y2] == 1) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
