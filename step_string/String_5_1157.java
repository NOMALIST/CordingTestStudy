package step_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class String_5_1157 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		
		int[] arr;
		arr = new int[26];
		
		for(int i=0; i<str.length(); i++ ) {
			char a = str.charAt(i);
			if('A' <= a && a <= 'Z') {
				arr[(int) a-'A']++;
			} else {
				arr[((int) a-'a')]++;
			}
		}
		
		int max = -1;
		int maxIndex = -1;
		boolean multi = false;
		
		for(int i=0; i<26; i++) {
			if(arr[i] > max) {
				max = arr[i];
				maxIndex = i;
				multi = false;
			} else if(arr[i] == max) {
				multi = true;
			}
		}
		
		if(multi) {
			bw.write("?");
		} else {
			bw.write((int)'A' + maxIndex);
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}
}
