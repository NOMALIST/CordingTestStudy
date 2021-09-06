package step_math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_11_1002 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int x1, x2, y1, y2 , r1, r2;
		int sum, dif;
		double dis;
		
		for(int i=1; i<=t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			r1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			r2 = Integer.parseInt(st.nextToken());
			
			dis = Math.sqrt((double)( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2) ));
			sum = r1 + r2;
			dif = Math.abs(r1 - r2);
			
			if(dif < dis && dis < sum) {	// 두개의 접점
				sb.append("2\n");
			} else if(dis == 0 && r1 == r2) {	// 동심원이고 반지름이 같을 때
				sb.append("-1\n");
			} else if(dif == dis || sum == dis) {	// 한개의 접점
				sb.append("1\n");
			} else {
				sb.append("0\n");
			}
		}
		
		System.out.println(sb.toString());
		br.close();
		
	}
}
