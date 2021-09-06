package step_for;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class For_11_10871 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int standard = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=n; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(standard > a) {
				bw.write(String.valueOf(a) + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
