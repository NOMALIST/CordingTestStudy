package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BackTracking_01_15649 {

	static boolean[] selected;
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		
		selected = new boolean[N + 1];
		selecte(N, 0, K);
		
		System.out.println(sb);
		br.close();
	}
	
	public static void selecte(int N, int selectN, int K) {
		if(K == selectN) {
			for(int i=0; i<K; i++) {
				sb.append(list.get(i) + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(!selected[i]) {
				selected[i] = true;
				list.add(i);
				selecte(N, selectN + 1, K);
				list.remove(selectN);
				selected[i] = false;
			}
		}
	}
}
