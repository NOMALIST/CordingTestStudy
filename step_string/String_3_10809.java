package step_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class String_3_10809 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		int[] arr = new int[26];
		
		Arrays.fill(arr, -1);
		
		for(int i=0; i<str.length(); i++ ) {
			int index = str.charAt(i)-'a';
			if(arr[index] == -1) arr[index] = i;
		}
		
		for(int a : arr) {
			bw.write(String.valueOf(a) + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
