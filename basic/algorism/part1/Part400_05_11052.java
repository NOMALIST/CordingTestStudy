package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_05_11052 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N + 1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(input[i-1]);
		}
		
		int[] cost = new int[N + 1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				
				if(cost[i] < cost[i-j] + arr[j]) {
					cost[i] = cost[i-j] + arr[j];
				}
			}
		}
		
		System.out.println(cost[N]);
		br.close();
	}
}
