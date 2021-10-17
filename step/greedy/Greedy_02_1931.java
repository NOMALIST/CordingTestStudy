package step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Greedy_02_1931 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] apply = new int[N][2];
		
		for(int i=0; i<N; i++) {
			String[] in = br.readLine().split(" ");
			apply[i][0] = Integer.parseInt(in[0]);
			apply[i][1] = Integer.parseInt(in[1]);
		}
		
		Arrays.sort(apply, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}
		});
		
//		Arrays.sort(apply, (o1, o2) -> o1[1] - o2[1]);
		
		int now = 0;
		int answer = 0;
		
		for(int i=0; i<N; i++) {
			if(apply[i][0] < now) continue;
			
			answer++;
			now = apply[i][1];
		}
		
		System.out.println(answer);
		br.close();
	}
}
