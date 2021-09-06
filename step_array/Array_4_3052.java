package step_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Array_4_3052 {

	public static void main(String[] args)  throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[42];
		
		for(int i=1; i<=10; i++) {
			int a = Integer.parseInt(br.readLine()) % 42;
			arr[a]++;
		}
		
		int count = 0;
		for(int i=0; i<=41; i++) {
			if(arr[i] != 0) {
				count++;
			}
		}
		bw.write(String.valueOf(count));

		bw.flush();
		bw.close();
		br.close();
	}
}
