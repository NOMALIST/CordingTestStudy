package boj.short_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Short_path_11401 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		int P = 1000000007;
		
		long a = 1;
		for(int i=1; i<=N; i++) {
			a = (a * i) % P;
		}
		
		long b = 1;
		for(int i=1; i<=K; i++) {
			b = (b * i) % P;
		}
		
		long c = 1;
		for(int i=1; i<=N-K; i++) {
			c = (c * i) % P;
		}
		
		System.out.println((a/((b*c) % P)) % P);
		
	}
}
