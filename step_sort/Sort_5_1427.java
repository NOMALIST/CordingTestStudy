package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_5_1427 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int[] arr = new int[10];
		
		int a;
		for(int i=0; i<str.length(); i++) {
			a = str.charAt(i) - '0';
			arr[a]++;
		}
		
		StringBuilder sb = new StringBuilder();
		char c;
		for(int i=9; i>=0; i--) {
			while(arr[i] > 0) {
				c = (char)('0' + i);
				sb.append(c);
				arr[i]--;
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
