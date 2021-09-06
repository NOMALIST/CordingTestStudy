package step_math2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Math_3_11653 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
				
		for(int i=2; i<=Math.sqrt(n); i++) {
			while(n%i == 0) {
				bw.write(String.valueOf(i) + "\n");
				n /= i;
			}
			if(n == 1) break;
		}
		if(n != 1) {
			bw.write(String.valueOf(n));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
