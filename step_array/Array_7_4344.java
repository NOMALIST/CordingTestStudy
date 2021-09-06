package step_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Array_7_4344 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int total = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<total; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			int sum = 0;
			
			for(int j=0; j<n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}
			
			double avg = (double) sum / n;
			
			int count = 0;
			for(int j=0; j<n; j++) {
				if(arr[j] > avg) {
					count++;
				}
			}
			
			bw.write(String.format("%.3f", (double)count/n*100) + "%\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
