package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BackTracking_06_2580 {

	static int[][] arr = new int[9][9];
	static int N = 0;
	static int[][] emptyCubic;
	static boolean findAnswer = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0; i<9; i++) {
			String[] in = br.readLine().split(" ");
			
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(in[j]);
			}
		}
		
		emptyCubic = new int[82][2];
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				if(arr[i][j] == 0) {
					emptyCubic[N][0] = i;
					emptyCubic[N++][1] = j;					
				}
			}
		}
		
		back(0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<9; i++) {
			for(int j=0; j<9; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		if(findAnswer) System.out.println(sb);
		br.close();
	}
	
	public static void back(int n) {
		if(n == N) {
			findAnswer = true;
			return;
		}
		
		int low = emptyCubic[n][0];
		int col = emptyCubic[n][1];
		for(int val : findCadidate(low, col)) {
			arr[low][col] = val;
			back(n + 1);
			if(findAnswer) return;
			arr[low][col] = 0;
		}
	}
	
	public static ArrayList<Integer> findCadidate(int low, int col) {
		
		boolean[] check = new boolean[10];
		
		for(int i=0; i<9; i++) {
			check[arr[low][i]] = true;
			check[arr[i][col]] = true;
		}
		
		int a = (low / 3) * 3;
		int b = (col / 3) * 3;
		
		for(int i=a; i<a+3; i++) {
			for(int j=b; j<b+3; j++) {
				check[arr[i][j]] = true;
			}
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<=9; i++) {
			if(!check[i]) {
				list.add(i);
			}
		}

		return list;
	}
}
