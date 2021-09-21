package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_11_14002 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N + 1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(input[i-1]);
		}
		
		// [i][0]은 현재까지 수열의 최대 길이
		// [i][1]은 수열의 앞 수의 index
		int[][] count = new int[N + 1][2];
		int ans = 0;
		for(int i=1; i<=N; i++) {
			int max = 0;
			for(int j=1; j<i; j++) {
				if(arr[j] < arr[i] && count[max][0] < count[j][0]) {
					max = j;
				}
			}
			count[i][0] = count[max][0] + 1;
			count[i][1] = max;
			
			if(count[ans][0] < count[i][0]) {
				ans = i;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(count[ans][0] + "\n");
		
		int index = ans;
		int i = count[ans][0];
		int[] numbers = new int[i];
		while(index != 0) {
			numbers[--i] = arr[index];
			index = count[index][1];
		}
		
		for(int a : numbers) {
			sb.append(a + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
}
