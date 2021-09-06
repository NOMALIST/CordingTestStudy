package step_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_7_1085 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int min = 99999;
		
		if(x < min) {
			min = x;
		}
		if(y < min) {
			min = y;
		}
		if(w-x < min) {
			min = w-x;
		}
		if(h-y < min) {
			min = h-y;
		}
		
		System.out.println(min);
	}
}
