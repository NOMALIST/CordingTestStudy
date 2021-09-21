package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_12_1912 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N + 1];
		int[] sum = new int[N + 1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(input[i - 1]);
		}
		
		sum[0] = -1;
		int ans = -1001;
		for(int i=1; i<=N; i++) {
			// 이전 수열이 -면 나부터 시작
			// 아니면 무조건 이어서
			if(sum[i-1] > 0) {
				sum[i] = sum[i-1] + arr[i];
			} else {
				sum[i] = arr[i];
			}
			
			if(ans < sum[i]) {
				ans = sum[i];
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
