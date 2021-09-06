package step_math2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Math_1_1978 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] isChecked = new boolean[1001];
		int multiple;
		
		isChecked[1] = true;
		for(int i=2; i<=1000; i++) {
			multiple = 2;
			while(i*multiple <= 1000) {
				isChecked[i*multiple++] = true;
			}
		}
		
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int count = 0;
		int num;
		for(int i=0; i<t; i++) {
			num = Integer.parseInt(st.nextToken());
			if(!isChecked[num]) count++;
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
	}
}
