package kakao_test;

import java.util.Arrays;

public class Programming2 {

	public static void main(String[] args) {
		
		int n = 797160;
		int k = 3;
		int answer = 0;
		
		boolean[] prime = new boolean[200000001];
		
		// 소수 찾기
		
		prime[0] = true;
		prime[1] = true;
		long a = (int)Math.sqrt(200000001);
		for(int i = 2; i<=a; i++) {
			if(!prime[i]) {
				int multiple = 2;
				while(multiple * i <= 200000000) {
					prime[multiple*i] = true;
					multiple++;
				}
			}
		}
		
		
		// 진수 변환
		int[] number = new int[21];
		int position = 0;
		
		while(Math.pow(k, position+1) <= n) {
			position++;
		}
		
		int i = 1;
		while(position >= 0 && n >= 0) {
			int temp = (int)Math.pow(k, position);
			if(temp <= n) {
				while(n >= temp) {
					n -= temp;
					number[i]++;
				}
			}
			position--;
			i++;
		}
		int len = i;
		
		for(i=len+1; i>0; i--) {
			if(number[i] == 0) {
				a = 0;
				position = 0;
				while(number[i-1] != 0) {
					a += number[i-1] * Math.pow(10, position);
					i--;
					position++;
				}
				if(a > 200000000) {
					boolean isPrime = true;
					for(int j=1; j<=200000000; j++) {

						if(!prime[j]) {
							if(a%j == 0) {
								isPrime = false;
								break;
							}
						}
					}
					if(isPrime) answer++;
				} else {
					if(!prime[(int)a]) {
						answer++;
					}					
				}
			}
		}
		
		
		
		System.out.println(answer);
		
		
		
	}
}
