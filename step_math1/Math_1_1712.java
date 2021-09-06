package step_math1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_1_1712 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int fixed = Integer.parseInt(st.nextToken());
		int variable = Integer.parseInt(st.nextToken());
		int price = Integer.parseInt(st.nextToken());
		int breakEvenPoint;
		if(price - variable != 0) {
			breakEvenPoint = (int)Math.ceil(fixed / ((double) price - variable));			
		} else {
			breakEvenPoint = -1;
		}
		
		if(breakEvenPoint < 0) System.out.println("-1");
		else {
			if(fixed / (price - variable) == breakEvenPoint) breakEvenPoint++;
			System.out.println(breakEvenPoint);
		}
		
	}
}
