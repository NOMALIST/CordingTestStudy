package step_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Math_9_1011 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int now = x;
			long speed = 0;
			int count = 0;
			while(now < y) {
				if(leastDistance(speed+1) <= y-now) {
					if(leastDistance(speed+1) == y-now) {
						count += speed+1;
						break;
					}
					speed++;
					now += speed;
					count++;
				} else if(leastDistance(speed) <= y-now) {
					if(leastDistance(speed) == y-now) {
						count += speed;
						break;
					}
					now += speed;
					count++;
				} else {
					speed--;
					now += speed;
					count++;
				}
			}
			bw.write(String.valueOf(count + "\n"));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static long leastDistance(long speed) {
				
		return speed*(speed+1)/2;
	}
}
