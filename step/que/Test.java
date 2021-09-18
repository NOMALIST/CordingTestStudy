package step.que;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		
		que.offer(1);
		que.offer(2);
		
		que.offerFirst(3);
		que.addFirst(4);
		
		System.out.println(que.poll());
		
		System.out.println(que.toString());
	}
}
