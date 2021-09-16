package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DataStructure_07_1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer> que = new LinkedList<Integer>();
		
		for(int i=1; i<=n; i++) {
			que.add(i);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for(int i=1; i<n; i++) {
			int count = 1;
			while(count < k) {
				que.add(que.poll());
				count++;
			}
			sb.append(que.poll() + ", ");
		}
		sb.append(que.poll() + ">");
		
		System.out.println(sb);
		br.close();
	}
}
