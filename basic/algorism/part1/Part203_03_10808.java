package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part203_03_10808 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int[] alpha = new int[26];
		for(int i=0; i<str.length(); i++) {
			alpha[str.charAt(i)-'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<26; i++) {
			sb.append(alpha[i] + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
