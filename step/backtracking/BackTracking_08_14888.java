package step.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackTracking_08_14888 {

	static int[] numbers;
	static int[] calc = new int[4];
	static int N, min = 2100000000, max = -2100000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		String[] arr;
		arr = br.readLine().split(" ");
		numbers = new int[N];
		
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(arr[i]);
		}
		
		arr = br.readLine().split(" ");
		for(int i=0; i<4; i++) {
			calc[i] = Integer.parseInt(arr[i]);
		}
		
		func(numbers[0], 1);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static void func(int res, int n) {
		
		if(n == N) {
			
			if(res > max) max = res;
			if(res < min) min = res;
			
			return;
		}
		
		if(calc[0] > 0) {
			calc[0]--;
			func(res + numbers[n], n + 1);
			calc[0]++;
		}
		
		if(calc[1] > 0) {
			calc[1]--;
			func(res - numbers[n], n + 1);
			calc[1]++;			
		}

		if(calc[2] > 0) {
			calc[2]--;
			func(res * numbers[n], n + 1);
			calc[2]++;
		}
		
		if(calc[3] > 0) {
			calc[3]--;
			func(res / numbers[n], n + 1);
			calc[3]++;
		}
	}
}
