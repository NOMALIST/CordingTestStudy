package basic.algorism.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bruteforce_01_16968 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int ans = 1;
		
		for(int i=0; i<input.length(); i++) {
			int n;
			
			if(input.charAt(i) == 'c') n = 26;
			else n = 10;
			
			if(i >= 1 && input.charAt(i) == input.charAt(i-1)) {
				n--;
			}
			
			ans *= n;
		}
		
		System.out.println(ans);
		br.close();
	}
}
