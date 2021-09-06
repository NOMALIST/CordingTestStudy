package step_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Math_4_2869 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		double up = Integer.parseInt(st.nextToken());
		double down = Integer.parseInt(st.nextToken());
		double goal = Integer.parseInt(st.nextToken());
		
		int day = (int) ( (goal-down)/(up-down) );
		if((goal-down)%(up-down) > 0) day++;
		
		bw.write(String.valueOf(day));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
