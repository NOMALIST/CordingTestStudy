package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part203_04_10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] alpha = new int[26];
		
		for(int i=0; i<26; i++) {
			alpha[i] = -1;
		}
		
		for(int i=0; i<str.length(); i++) {
			if(alpha[str.charAt(i)-'a'] == -1) {
				alpha[str.charAt(i)-'a'] = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			sb.append(alpha[i] + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
