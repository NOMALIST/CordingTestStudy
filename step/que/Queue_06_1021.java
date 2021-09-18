package step.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_06_1021 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=N; i++) {
			que.offer(i);
		}
		
		int cnt1 = 0;
		int cnt2 = 0;
		
		
		while(M-- > 0) {
			int goal = Integer.parseInt(st.nextToken());
			
			if(que.indexOf(goal) <= que.size()/2) {
				while(que.peek() != goal) {
					que.offer(que.poll());
					cnt1++;
				}
			} else {
				while(que.peek() != goal) {
					que.addFirst(que.pollLast());
					cnt2++;
				}
			}
			
			que.poll();
		}
		
		System.out.println(cnt1 + cnt2);
		br.close();
	}
}
