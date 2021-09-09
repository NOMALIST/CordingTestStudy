package step_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Brute_5_1436 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int index = 666;
		int count = 0;
		while(true) {
			if(func(index)) {
				count++;
				if(count == n) {
					break;
				}
			}
			index++;
		}
		
		System.out.println(index);
		br.close();
	}
	
	// 연속된 666이 있는지 확인하는 함수
	public static boolean func(int n) {
		boolean res = false;

		while(n >= 666) {
			if(n%1000 == 666) {
				res = true;
				break;
			}
			n /= 10;
		}
		
		return res;
	}
}
