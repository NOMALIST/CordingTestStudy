package step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_01_11047 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		
		int N = Integer.parseInt(in[0]);
		int K = Integer.parseInt(in[1]);
		
		int[] coin = new int[N];
		
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			coin[i] = Integer.parseInt(input);
		}
		
		int count = 0;
		for(int i=N-1; i>=0; i--) {
			int value = coin[i];
			if(K >= value) {
				int a = K/value;
				count += a;
				K -= a * value;
			}
			
			if(K == 0) break;
		}
		
		System.out.println(count);
		br.close();
	}
}
