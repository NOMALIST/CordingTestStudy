package step_math1;

import java.util.Scanner;

public class Math_3_1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int goal = sc.nextInt();
		
		int now = 1;
		int nextStep = 2;
		
		if(goal == 1) {
			System.out.println("1/1");
		} else {
			while(!(goal <= now + nextStep)) {
				now += nextStep++;
			}
			
			int a = nextStep-(goal-now)+1;
			int b = goal-now;
			
			if(nextStep%2 == 1) {
				System.out.println(a + "/" + b);
			} else {
				System.out.println(b + "/" + a);
			}
		}
		
		sc.close();
	}
}
