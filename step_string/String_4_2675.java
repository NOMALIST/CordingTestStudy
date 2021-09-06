package step_string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class String_4_2675 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st; 
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cycle = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			for(int j=0; j<str.length(); j++) {
				for(int k=0; k<cycle; k++) {
					bw.write(str.charAt(j));
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
