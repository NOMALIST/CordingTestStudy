package step.essence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Essence_01_5086 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int a = Integer.parseInt(input[0]);
		int b = Integer.parseInt(input[1]);
		
		StringBuilder sb = new StringBuilder();
		
		while(a != 0 && b != 0) {
			
			if(b % a == 0) {	// 약수일때
				sb.append("factor").append("\n");
			} else if(a % b == 0) {	// 배수일때
				sb.append("multiple").append("\n");
			} else {
				sb.append("neither").append("\n");
			}
				
			
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
		}
		
		System.out.println(sb);
	}
}
