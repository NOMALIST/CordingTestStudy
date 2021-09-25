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
			
			// 입력값 받기
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			// q는 출력순서를 알고자 하는 목표
			int q = Integer.parseInt(st.nextToken());
			
			String[] str = br.readLine().split(" ");
			// 우선순위 가 들어있는 배열
			int[] pri = new int[n];
			// index가 들어있는 큐
			LinkedList<Integer> que = new LinkedList<Integer>();
			
			// que에 출력순서를 저장
			for(int j=0; j<n; j++) {
				pri[j] = Integer.parseInt(str[j]);
				que.offer(j);
			}
			
			int ans = -1;
			// j는 프린트 하는 순서
			for(int j=1; j<=n; j++) {
				int maxPri = -1;
				int maxIndex = -1;
				// 큐를 size만큼 돌면서 max값 찾기
				for(int k=0; k<que.size(); k++) {
					if(maxPri < pri[que.peek()]) {
						maxPri = pri[que.peek()];
						maxIndex = que.peek();
					}
					
					que.offer(que.poll());
				}
				
				// max 값이 목표물이면 현재 번호를 출력
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
