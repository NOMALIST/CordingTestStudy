package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_10_11053 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] input = br.readLine().split(" ");
		int[] arr = new int[N + 1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(input[i-1]);
		}
		
		int[] count = new int[N + 1];
		int ans = -1;
		for(int i=1; i<=N; i++) {
			int max = 0;
			for(int j=1; j<i; j++) {
				if(arr[j] < arr[i] && max < count[j]) {
					max = count[j];
				}
			}
			count[i] = max + 1;
			
			if(ans < count[i]) {
				ans = count[i];
			}
		}
		
		System.out.println(ans);
		br.close();
	}
}
