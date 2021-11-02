package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking_09_14889 {

	static int[][] point;
	static boolean[] team;
	static int N;
	static int ans = 2100000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		point = new int[N][N];
		team = new boolean[N];
		
		for(int i=0; i<N; i++) {
			String[] in = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				point[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		match(N/2, 0);
		
		System.out.println(ans);
		
		
	}
	
	static void match(int leftCount, int nowIndex) {
		if(leftCount == 0) {
			pointCalc();
			return;
		}
		
		if(nowIndex == N) {	
			return;
		}
		
		team[nowIndex] = true;
		match(leftCount - 1, nowIndex + 1);
		
		team[nowIndex] = false;
		match(leftCount, nowIndex + 1);
	}
	
	static void pointCalc() {
		int team1 = 0;
		int team2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				if(team[i] && team[j]) {
					team1 += point[i][j];
					team1 += point[j][i];
				}
				
				if(!team[i] && !team[j]) {
					team2 += point[i][j];
					team2 += point[j][i];
				}
			}
		}
		
		int diff = Math.abs(team1 - team2);
		
		if(ans > diff) ans = diff;
	}
}
