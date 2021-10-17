package step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_04_1541 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split("-");
		
		int sum = 0;
		String[] first = in[0].split("\\+");
		
		for(String a : first) {
			sum += Integer.parseInt(a);
		}
		
		for(int i=1; i<in.length; i++) {
			String[] str = in[i].split("\\+");
			for(String a : str) {
				sum -= Integer.parseInt(a);
			}
		}
		
		System.out.println(sum);
		br.close();
	}
}
