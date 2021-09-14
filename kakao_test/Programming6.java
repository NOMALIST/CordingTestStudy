package kakao_test;

public class Programming6 {

	public static void main(String[] args) {
		
		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		int answer = 0;
		
		int n = board.length;
		int m = board[0].length;
		int attack;
		int critia = 0;
		for(int i=0; i<skill.length; i++) {
			if(skill[i][0] == 1) {
				attack = skill[i][5] * -1;
			} else {
				attack = skill[i][5];
			}
			
			int r1 = skill[i][1];
			int c1 = skill[i][2];
			int r2 = skill[i][3];
			int c2 = skill[i][4];
			
			if(r2-r1 == n-1 && c2-c1 == m-1) {
				critia -= attack;
				continue;
			}
			
			for(int j=r1; j<=r2; j++) {
				for(int k=c1; k<=c2; k++) {
					board[j][k] += attack;
				}
			}
		}
		

		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] > critia) answer++;
			}
		}
		
		System.out.println(answer);
	}
}
