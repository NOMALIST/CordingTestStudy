package programmers.practice;

import java.util.HashMap;
import java.util.Map;

// level2 단체사진찍기
public class GroupPicture {

	public static void main(String[] args) {
		
		String[] input = {"M~C<2", "C~M>1"};
		int ans = solution(2, input);
		
		System.out.println(ans);
		
	}
	
	static boolean[] check = new boolean[8];
	static int[] position = new int[8];
	static int answer = 0;
	static String[] condition;
	static Map<Character, Integer> charecter = new HashMap<Character, Integer>();
	
	public static int solution(int n, String[] data) {
		
		condition = data;
		charecter.put('A', 0);
		charecter.put('C', 1);
		charecter.put('F', 2);
		charecter.put('J', 3);
		charecter.put('M', 4);
		charecter.put('N', 5);
		charecter.put('R', 6);
		charecter.put('T', 7);
		
		back(0);
		
		return answer;
	}
	
	public static void back(int n) {
		
		if(n == 8) {
			conditionCheck();
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(!check[i]) {
				check[i] = true;
				position[n] = i;
				back(n + 1);
				position[n] = 0;
				check[i] = false;
			}
		}
	}
	
	public static void conditionCheck() {
		for(String c : condition) {
			int a = charecter.get(c.charAt(0));
			int b = charecter.get(c.charAt(2));
			int space = Math.abs(position[a] - position[b]) - 1;
			char eq = c.charAt(3);
			int number = c.charAt(4) - '0';
			if(eq == '=') {
				if(space != number) return;
			} else if(eq == '<') {
				if(space >= number) return;
			} else {
				if(space <= number) return;
			}
		}
		
		answer++;
	}
}
