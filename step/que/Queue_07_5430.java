package step.que;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Queue_07_5430 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(T-- > 0) {
			String P = br.readLine();
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) {
				if(P.contains("D")) {
					sb.append("error\n");
				} else {
					sb.append("[]\n");
				}
				br.readLine();
				continue;
			}
			
			String str = br.readLine();
			str = str.substring(1, str.length()-1);
			String[] arr = str.split(",");
			
			LinkedList<Integer> que = new LinkedList<Integer>();
			for(String a : arr) {
				que.offer(Integer.parseInt(a));
			}
			
			boolean isFoward = true;
			boolean isError = false;
			
			for(int i=0; i<P.length(); i++) {
				char a = P.charAt(i);
				switch (a) {
					case 'R':
						isFoward = !isFoward;
						break;
					case 'D':
						if(que.isEmpty()) {
							isError = true;
							break;
						}
						
						if(isFoward) {
							que.pollFirst();
						} else {
							que.pollLast();
						}
						break;
				}
			}
			
			if(isError) {
				sb.append("error\n");
			} else {
				sb.append("[");
				int size = que.size();
				for(int i=1; i<size; i++) {
					if(isFoward) {
						sb.append(que.poll() + ",");
					} else {
						sb.append(que.pollLast() + ",");
					}
				}
				if(!que.isEmpty()) {
					sb.append(que.poll());
				}
				sb.append("]\n");
			}
			
		}
		System.out.println(sb);
		br.close();
	}
}
