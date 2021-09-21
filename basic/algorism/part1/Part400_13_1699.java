package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_13_1699 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N + 1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = 2100000000;
		}
		
		arr[1] = 1;
		
		for(int i=2; i<=N; i++) {
			int a;
			// Math.sqrt(i) 로 비교하는 것보다 j*j로 비교하는게 더 빠름
			for(int j=1; (a = j*j) <= i; j++) {
				if(arr[i-a] + 1 < arr[i]) {
					arr[i] = arr[i-a] + 1;
				}
			}
		}
		
		System.out.println(arr[N]);
		br.close();
	}
}
