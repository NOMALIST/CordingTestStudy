package step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy_03_11399 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] in = br.readLine().split(" ");
		int[] mans = new int[N];
		for(int i=0; i<N; i++) {
			mans[i] = Integer.parseInt(in[i]);
		}
		
		Arrays.sort(mans);
		
		int answer = 0;
		int now = 0;
		
		for(int a : mans) {
			answer += now + a;
			now += a;
		}
		
		System.out.println(answer);
		br.close();
	}
}
