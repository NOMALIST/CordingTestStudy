package step_math1;

import java.util.Scanner;

public class Math_2_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int goal = sc.nextInt();
		
		int nowStep = 0;
		int beginIndex = 1;
		int endIndex = 1;
		int ans;
		while(true) {
			if(beginIndex <= goal && goal <= endIndex) {
				ans = nowStep + 1;
				break;
			}
			nowStep++;
			beginIndex = endIndex + 1;
			endIndex = beginIndex + (nowStep * 6) - 1;
		}
		
		System.out.println(ans);
		sc.close();
	}
}
