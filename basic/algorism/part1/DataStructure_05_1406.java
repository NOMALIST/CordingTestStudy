package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DataStructure_05_1406 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Character> arr = new ArrayList<Character>();
		
		String str = br.readLine();

		for(int i=0; i<str.length(); i++) {
			arr.add(str.charAt(i));
		}
		
		int n = Integer.parseInt(br.readLine());
		int cursor = str.length();
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String a = st.nextToken();
			if("L".equals(a)) {
				cursor--;
				if(cursor < 0) cursor = 0;
			} else if("D".equals(a)) {
				cursor++;
				if(cursor > arr.size()) cursor = arr.size();
			} else if("B".equals(a)) {
				if(cursor != 0) {
					arr.remove(cursor-1);
					cursor--;
				}
			} else {
				char b = st.nextToken().charAt(0);
				arr.add(cursor++, b);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.size(); i++) {
			sb.append(arr.get(i));
		}
		
		System.out.println(sb);
		br.close();
		
	}
}
