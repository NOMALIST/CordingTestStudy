package step_math2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Math_2_2581 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] isChecked = new boolean[10001];
		int multiple;
		
		isChecked[1] = true;
		for(int i=2; i<=10000; i++) {
			multiple = 2;
			while(i*multiple <= 10000) {
				isChecked[i*multiple++] = true;
			}
		}
		
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = 9999999;
		for(int i=m; i<=n; i++) {
			if(!isChecked[i]) {
				sum += i;
				if(min > i) min = i;
			}
		}
		
		if(min == 9999999) {
			bw.write("-1");
		} else {
			bw.write(String.valueOf(sum) + "\n" + String.valueOf(min));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
