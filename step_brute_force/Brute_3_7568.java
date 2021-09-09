package step_brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Brute_3_7568 {

	public static int[][] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		arr = new int[n][2];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			sb.append(func(i, n) + " ");
		}
		
		System.out.println(sb);
		br.close();
	}
	
	// 배열의 n번째 를 input하면 덩치가 큰 사람의 수를 알려주는 메서드
	public static int func(int a, int n) {
		int count = 0;
		
		for(int i=0; i<n; i++) {
			if(arr[a][1] < arr[i][1] && arr[a][0] < arr[i][0]) {
				count++;
			}
		}
		
		return count+1;
	}
}
