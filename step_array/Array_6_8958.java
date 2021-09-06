package step_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Array_6_8958 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		for(int i=0; i<num; i++) {
			String result = br.readLine();
			int totalPoint = 0;
			int point = 1;
			for(int j=0; j<result.length(); j++) {
				if(result.charAt(j) == 'X') {
					point = 1;
				} else {
					totalPoint += point;
					point++;
				}
			}
			bw.write(String.valueOf(totalPoint) + "\n");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
