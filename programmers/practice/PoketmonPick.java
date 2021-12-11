package programmers.practice;

import java.util.HashMap;
import java.util.Map;

public class PoketmonPick {

	public static void main(String[] args) {
		int[] input = {3,3,3,2,2,2};
		System.out.println(solution(input));
	}
	
	public static int solution(int[] nums) {
		Map<Integer, Integer> poketmon = new HashMap<Integer, Integer>();
		
		for(int a : nums) {
			if(poketmon.containsKey(a)) {
				poketmon.put(a, poketmon.get(a) + 1);
				
				
				
			} else {
				poketmon.put(a, 1);
			}
		}
		
		if(poketmon.size() > nums.length / 2) {
			return nums.length / 2;
		} else {
			return poketmon.size();
		}
		
	}
}
