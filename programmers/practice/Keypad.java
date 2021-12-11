package programmers.practice;

import java.util.HashMap;
import java.util.Map;

public class Keypad {

	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		
		System.out.println(solution(numbers, hand));
	}
	
	public static String solution(int[] numbers, String hand) {
		
		StringBuilder sb = new StringBuilder();
		
		// 편의상 *은 10, 0은 11, #은 12로 연산
		
		int left = 10, right = 12;
		
		Map<Integer, int[]> position = new HashMap<Integer, int[]>();
		
		for(int i=0; i<4; i++) {
			for(int j=0; j<3; j++) {
				int[] a = {i, j};
				position.put(i * 3 + j + 1, a);
			}
		}
		
		for(int n : numbers) {
			
			if(n == 0) n = 11;
			
			int leftDistance = distance(position.get(left), position.get(n));
			int rightDistance = distance(position.get(right), position.get(n));
			
			if(n == 1 || n == 4 || n== 7) {
				sb.append("L");
				left = n;
				continue;
			} else if(n == 3 || n == 6 || n == 9) {
				sb.append("R");
				right = n;
				continue;
			}
			
			
			if(leftDistance < rightDistance) {
				sb.append("L");
				left = n;
			} else if(leftDistance > rightDistance) {
				sb.append("R");
				right = n;
			} else {
				if(hand.equals("right")) {
					sb.append("R");
					right = n;
				} else {
					sb.append("L");
					left = n;
				}
			}
		}
		
		return sb.toString();
	}
	
	public static int distance(int[] a, int[] b) {
		
		return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
	}
}
