package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part203_08_10824 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		long ans = Long.parseLong(input[0] + input[1]) + Long.parseLong(input[2] + input[3]);
		
		System.out.println(ans);
		br.close();
		
	}
}
