package step_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Math_5_10250 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		int h, w, n, a, b;
		StringTokenizer st;
		for(int i=1; i<=t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			a = n/h;
			b = n%h;
			if(b == 0) {
				bw.write(String.valueOf(h * 100 + a) + "\n");
				continue;
			}
			bw.write(String.valueOf(b*100 + a + 1) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
