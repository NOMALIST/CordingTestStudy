package step_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_8_5622 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int time = 0;
		
		for(int i=0; i<str.length(); i++) {
			time += spendTime(str.charAt(i));
		}
		
		System.out.println(time);
		
		
	}
	
	public static int spendTime(char a) {
		
		int num;
		
		if('A' <= a && a <= 'C') {
			num = 2;
		} else if('D' <= a && a <= 'F') {
			num = 3;
		} else if('G' <= a && a <= 'I') {
			num = 4;
		} else if('J' <= a && a <= 'L') {
			num = 5;
		} else if('M' <= a && a <= 'O') {
			num = 6;
		} else if('P' <= a && a <= 'S') {
			num = 7;
		} else if('T' <= a && a <= 'V') {
			num = 8;
		} else {
			num = 9;
		}
		
		return num + 1;
	}
}
