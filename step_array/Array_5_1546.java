package step_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Array_5_1546 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int num = Integer.parseInt(br.readLine());
		double[] arr = new double[num];
		double max = -1;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<num; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		
		double sum = 0;
		for(int i=0; i<num; i++) {
			arr[i] = (arr[i]/max) *100;
			sum += arr[i];
		}
		
		double avg = sum/num;
		
		bw.write(String.valueOf(avg));
		
		bw.flush();
		bw.close();
		br.close();
	}
}
