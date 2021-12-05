package boj.short_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Short_path_1655_2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>(Comparator.reverseOrder());
		PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(maxPQ.size() == minPQ.size()) {
				maxPQ.add(number);				
			} else {
				minPQ.add(number);				
			}
			
			if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
				minPQ.add(maxPQ.poll());
				maxPQ.add(minPQ.poll());
			}
			
			sb.append(maxPQ.peek() + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
