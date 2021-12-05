package boj.short_pack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Short_path_1655 {

	private static ArrayList<Integer> array = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=N; i++) {
			int input = Integer.parseInt(br.readLine());
			
			insert(input);
			
			if(i % 2 == 0) {
				int output = Math.min(array.get(i/2), array.get(i/2 - 1));
				sb.append(output + "\n");
			} else {
				sb.append(array.get(i/2) + "\n");				
			}
		}
		
		System.out.println(sb);
		br.close();
	}
	
	private static void insert(int input) {
		int start = 0;
		int end = array.size() - 1;
		
		while(start <= end) {
			int mid = (start + end) / 2;
			//System.out.println("start:" + start + " end:" + end + " size:" + array.size());
			
			if(array.get(mid) == input) {
				start = mid;
				break;
			} else if(array.get(mid) > input) {
				end = mid;
				if(start == end) break;
			} else {
				start = mid + 1;
			}
		}
		
		array.add(start, input);
	}
}
