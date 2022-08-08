package setp.DP;

import java.util.Scanner;

public class DP_00_24416 {

	/**
	 * 피보나치 수를 계살할때, 재귀방식과 동적프로그래밍 방식의 호출 횟수를 비교하는 알고리즘
	 */
	
	static int CNT1 = 0;
	static int CNT2 = 0;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int ans1 = recursion(num);
		int ans2 = dp(num);
		
		System.out.println(CNT1 + " " + CNT2);
		//System.out.println(ans1 + " " + ans2);
		
		
		sc.close();
		
	}
	
	public static int recursion(int num) {
		
		if(num == 1 || num == 2) {
			CNT1++;
			return 1;
		}
		
		return recursion(num - 1) + recursion(num - 2);
	}
	
	public static int dp(int num) {
		
		int[] arr = new int[41];
		arr[1] = arr[2] = 1;
		
		for(int i=3; i<=num; i++) {
			CNT2++;
			arr[i] = arr[i-1] + arr[i-2];
		}
		
		return arr[num];
	}
}
