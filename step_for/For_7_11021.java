package step_for;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class For_7_11021 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=1; i<=num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			bw.write("Case #" + String.valueOf(i) + ": ");
			bw.write(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken()) + "\n");
		}
		
		br.close();
		bw.close();
	}
}
