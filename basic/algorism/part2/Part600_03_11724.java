package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Part600_03_11724 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		for(int i=0; i<=N; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=M; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			
			arrList.get(a).add(b);
			arrList.get(b).add(a);
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		boolean[] visited = new boolean[N + 1];
		
		int compoCnt = 0;
		for(int i=1; i<=N; i++) {
			if(!visited[i]) {
				compoCnt++;
				stack.add(i);
				while(!stack.isEmpty()) {
					int now = stack.pop();
					for(int a : arrList.get(now)) {
						if(!visited[a]) {
							stack.push(a);
							visited[a] = true;
						}
					}
				}
			}
		}
		
		System.out.println(compoCnt);
		br.close();
		
	}
}
