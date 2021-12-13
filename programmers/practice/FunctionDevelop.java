package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// level2 기능개발
public class FunctionDevelop {

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		
		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = progresses.length - 1; i>=0; i--) {
        	stack.push(i);
        }
        
        while(!stack.isEmpty()) {
        	for(int i=0; i<progresses.length; i++) {
        		progresses[i] += speeds[i];
        	}
        	
        	int count = 0;
        	while(progresses[stack.peek()] >= 100) {
        		count++;
        		stack.pop();
        		if(stack.isEmpty()) break;
        	}
        	
        	if(count != 0) answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
