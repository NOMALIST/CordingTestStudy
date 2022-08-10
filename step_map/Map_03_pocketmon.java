package step_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Map_03_pocketmon {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputString = br.readLine();
		int N = Integer.parseInt(inputString.split(" ")[0]);
		int M = Integer.parseInt(inputString.split(" ")[1]);
		
		String[] pocketmon = new String[N+1];
		
		
		Map<String, Integer> pocketmon2 = new HashMap<String, Integer>();
		
		for(int i=1; i<=N; i++) {
			inputString = br.readLine();
			
			pocketmon[i] = inputString;
			pocketmon2.put(inputString, i);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=M; i++) {
			inputString = br.readLine();
			
			if(isNumeric(inputString)) {
				int n = Integer.parseInt(inputString);
				sb.append(pocketmon[n] + "\n");
			} else {
				sb.append(pocketmon2.get(inputString) + "\n");
			}
		}
		
		
		System.out.println(sb);
		br.close();
		
	}
	
	public static boolean isNumeric(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
