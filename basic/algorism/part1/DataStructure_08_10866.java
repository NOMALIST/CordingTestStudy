package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DataStructure_08_10866 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> que = new LinkedList<Integer>();
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			switch (a) {
			case "push_front":
				que.push(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				que.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(que.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(que.pollFirst() + "\n");
				}
				break;
			case "pop_back":
				if(que.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(que.pollLast() + "\n");
				}
				break;
			case "size":
				sb.append(que.size() + "\n");
				break;
			case "empty":
				if(que.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "front":
				if(que.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(que.peekFirst() + "\n");
				}
				break;
			case "back":
				if(que.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(que.peekLast() + "\n");
				}
				break;

			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
