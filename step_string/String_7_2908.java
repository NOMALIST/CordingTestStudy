package step_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class String_7_2908 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int num1 = ((int)str1.charAt(0)-'0') + ((int)str1.charAt(1)-'0')*10 + ((int)str1.charAt(2)-'0')*100; 
		int num2 = ((int)str2.charAt(0)-'0') + ((int)str2.charAt(1)-'0')*10 + ((int)str2.charAt(2)-'0')*100;
		
		if(num1 > num2) {
			bw.write(String.valueOf(num1));
		} else {
			bw.write(String.valueOf(num2));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
