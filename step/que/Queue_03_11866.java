package step.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Queue_03_11866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			que.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		for(int i=1; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j == k) {
					sb.append(que.poll() + ", ");
				} else {
					que.offer(que.poll());
				}
			}
		}
		
		sb.append(que.poll() + ">");
		
		System.out.println(sb);
		br.close();
	}
}
