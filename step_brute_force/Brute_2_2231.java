package step_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brute_2_2231 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		for(int i=n/2; i<=n; i++) {
			if(func(i) == n) {
				ans = i;
				break;
			}
		}
		
		System.out.println(ans);
		br.close();
	}
	
	public static int func(int n) {
		int res = n;
		
		while(n > 0) {
			res += n%10;
			n /= 10;
		}
		
		return res;
	}
}
