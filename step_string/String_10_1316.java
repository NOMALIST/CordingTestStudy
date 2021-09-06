package step_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_10_1316 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		String str;
		boolean[] arr;
		boolean isGroupWord;
		int count = 0;
		
		for(int i=0; i<num; i++) {
			str = br.readLine();
			arr = new boolean[26];
			isGroupWord = true;
			
			for(int j=0; j<str.length(); j++) {
				char a = str.charAt(j);
				if(arr[a-'a']) {
					if(str.charAt(j-1) != a) {
						isGroupWord = false;
						break;
					}
				} else {
					arr[a-'a'] = true;
				}
			}
			if(isGroupWord) count++;
		}
		
		System.out.println(count);
		br.close();
	}
}
