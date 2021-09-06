package step_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class String_6_1152 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		/*
		int count = 0;
		
		while(st.hasMoreTokens()) {
			st.nextToken();
			count++;
		}
		
		bw.write(String.valueOf(count));
		*/
		
		bw.write(String.valueOf(st.countTokens()));
		bw.flush();
		bw.close();
		br.close();
	}
}
