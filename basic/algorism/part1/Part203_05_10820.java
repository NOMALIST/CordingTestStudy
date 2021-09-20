package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part203_05_10820 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		StringBuilder sb = new StringBuilder();
		while((str = br.readLine()) != null) {
			int[] counts = new int[4];
			
			for(int i=0; i<str.length(); i++) {
				char c = str.charAt(i);
				// 소문자, 대문자, 숫자, 공백
				if(c == ' ') {
					counts[3]++;
				} else if('a' <= c && c <= 'z') {
					counts[0]++;
				} else if('A' <= c && c <= 'Z') {
					counts[1]++;
				} else {
					counts[2]++;
				}
			}
			
			for(int a : counts) {
				sb.append(a + " ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
