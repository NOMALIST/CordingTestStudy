package step.essence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Essence_03_2609 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int n = N;
		int m = M;
		while(m != 0) {
			int r = n % m;
			n = m;
			m = r;
		}
		
		System.out.println(n);
		System.out.println((N/n) * (M/n) * n);
		
	}
}
