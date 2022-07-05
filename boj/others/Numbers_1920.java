package boj.others;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Numbers_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Map<Integer, Integer> check = new HashMap<Integer, Integer>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int a;
		
		for(int i=0; i<N; i++) {
			a = Integer.parseInt(st.nextToken());
			check.put(a, 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			a = Integer.parseInt(st.nextToken());
			bw.write( (check.containsKey(a)) ? "1" : "0" );
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
