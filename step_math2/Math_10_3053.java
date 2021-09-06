package step_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Math_10_3053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int r = Integer.parseInt(br.readLine());
		
		double pi = Math.PI;
		
		double ans1 = r*r*pi;
		double ans2 = r*r*2.0;
		
		System.out.println(ans1);
		System.out.println(ans2);
		br.close();
	}
}
