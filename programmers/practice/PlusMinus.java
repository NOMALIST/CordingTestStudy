package programmers.practice;

import java.util.Arrays;

public class PlusMinus {

	public static void main(String[] args) {
		
		int[] input1 = {4,7,12};
		boolean[] input2 = {true,false,true};
		
		System.out.println(solution(input1, input2));
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
		
		int result = 0;
		
		for(int i=0; i<absolutes.length; i++) {
			result += signs[i] ? (absolutes[i]) : (absolutes[i] * -1); 
		}
		return result;
	}
}
