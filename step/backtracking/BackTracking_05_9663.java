package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking_05_9663 {

	static int answer = 0;
	static boolean[] isUsedLow;
	static boolean[] isUsedCross1;	// 우측 대각선
	static boolean[] isUsedCross2;	// 좌측 대각선
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		isUsedLow = new boolean[N + 1];
		isUsedCross1 = new boolean[2 * N];
		isUsedCross2 = new boolean[2 * N];
		
		back(0);
		
		System.out.println(answer);
		br.close();
		
	}
	
	public static void back(int now) {
		
		if(now == N) {
			answer++;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			boolean isEmpty = true;
			
			if(isUsedLow[i] || isUsedCross1[N - (now + 1) + i] || isUsedCross2[i + now]) continue;
			
			if(isEmpty) {
				isUsedLow[i] = true;
				isUsedCross1[N - (now + 1) + i] = true;
				isUsedCross2[i + now] = true;
				back(now + 1);
				isUsedLow[i] = false;
				isUsedCross1[N - (now + 1) + i] = false;
				isUsedCross2[i + now] = false;
			}
			
		}
	}
}
