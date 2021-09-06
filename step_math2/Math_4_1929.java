package step_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_4_1929 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		boolean[] checked = new boolean[n+1];
		checked[1] = true;
		
		int multiple;
		
		for(int i=2; i<=Math.sqrt(n); i++) {
			
			if(checked[i]) {
				continue;
			} else {
				multiple = i;
				while(i*multiple <= n) {
					checked[i*multiple] = true;
					multiple++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=m; i<=n; i++) {
			if(!checked[i]) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
	}
}
