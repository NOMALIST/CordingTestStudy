package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Part203_09_11656 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String[] arr = new String[word.length()];
		
		for(int i=0; i<word.length(); i++) {
			arr[i] = word.substring(i);
		}
		
		Arrays.sort(arr);
		
		StringBuilder sb = new StringBuilder();
		
		for(String str : arr) {
			sb.append(str + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
