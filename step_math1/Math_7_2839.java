package step_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Math_7_2839 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int ans;
		int mod = n%5;
		if(mod == 0) {
			ans = n/5;
		} else if(mod == 1) {
			if(n < 6) {
				ans = -1;
			} else {
				ans = n/5 + 1;	// 5+1 -> 3+3
			}
		} else if(mod == 2) {
			if(n < 12) {
				ans = -1;
			} else {
				ans = n/5 + 2;	// 5+5+2 -> 3+3+3+3
			}
		} else if(mod == 3) {
			ans = n/5 + 1;
		} else {
			if(n < 9) {
				ans = -1;
			} else {
				ans = n/5 + 2; // 5+4 -> 3+3+3
			}
		}
		
		bw.write(String.valueOf(ans));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
