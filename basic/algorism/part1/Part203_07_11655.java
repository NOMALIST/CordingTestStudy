package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part203_07_11655 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			
			if('A' <= c && c <= 'Z') {
				c += 13;
				if(c > 'Z') c -= 26;
			} else if('a' <= c && c <= 'z') {
				c += 13;
				if(c > 'z') c -= 26;
			}
			
			sb.append(c);
		}
		
		System.out.println(sb);
		br.close();
	}
}
