package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_04_9095 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[11];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for(int i=4; i<=10; i++) {
			arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=N; i++) {
			int tc = Integer.parseInt(br.readLine());
			sb.append(arr[tc] + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
