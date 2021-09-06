package step_array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Array_1_10818 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int index = 0;
		int[] arr = new int[num];
		while(st.hasMoreTokens()) {
			arr[index++] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		bw.write(String.valueOf(arr[0]) + " " + String.valueOf(arr[num-1]));
		bw.flush();
		bw.close();
		br.close();
	}
}
