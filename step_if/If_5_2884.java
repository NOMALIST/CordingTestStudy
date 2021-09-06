package step_if;

import java.util.Scanner;

public class If_5_2884 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h, m;
		h = sc.nextInt();
		m = sc.nextInt();
		
		if(m >= 45) {
			m -= 45;
		} else {
			m = m-45+60;
			h -= 1;
			if(h < 0) {
				h += 24;
			}
		}
		System.out.println(h + " " + m);
		sc.close();
	}
}
