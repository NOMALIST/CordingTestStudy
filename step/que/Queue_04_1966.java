package step.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_04_1966 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		while(test-- > 0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			String[] str = br.readLine().split(" ");
			int[] pri = new int[n];
			LinkedList<Integer> que = new LinkedList<Integer>();
			
			for(int j=0; j<n; j++) {
				pri[j] = Integer.parseInt(str[j]);
				que.offer(j);
			}
			
			int ans = -1;
			for(int j=1; j<=n; j++) {
				int maxPri = -1;
				int maxIndex = -1;
				for(int k=0; k<que.size(); k++) {
					if(maxPri < pri[que.peek()]) {
						maxPri = pri[que.peek()];
						maxIndex = que.peek();
					}
					
					que.offer(que.poll());
				}
				
				if(maxIndex == q) {
					ans = j;
					break;
				}
				
				while(que.peek() != maxIndex) {
					que.offer(que.poll());
				}
				
				pri[que.poll()] = -1;
			}
			
			sb.append(ans + "\n");
		}
		
		System.out.println(sb);
		br.close();		
		
	}
}
