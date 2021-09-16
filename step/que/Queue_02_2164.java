package step.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue_02_2164 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		
		for(int i=n; i>=1; i--) {
			que.push(i);
		}
		
		for(int i=1; i<n; i++) {
			que.poll();
			que.addLast(que.poll());
		}
		
		System.out.println(que.poll());
		br.close();
	}
}
