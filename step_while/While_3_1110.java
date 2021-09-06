package step_while;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class While_3_1110 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int cycle = 0;
		int target = num;
		while(true) {
			int a = target%10;
			int b = (target/10 + target%10)%10;
			target = a*10 + b;
			cycle++;
			if(target == num) {
				break;
			}
		}
		bw.write(String.valueOf(cycle));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
