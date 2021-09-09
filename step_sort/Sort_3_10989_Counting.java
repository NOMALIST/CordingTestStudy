package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 내장 정렬 메서드 사용시
 * time : 2532 ms
 * memory : 418356 KB
 * 
 * 카운팅 정렬 사용시
 * time : 1892 ms
 * memory : 384516 KB
 */
public class Sort_3_10989_Counting {

	public static int[] poArr = new int[10001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int a;
		for(int i=0; i<n; i++) {
			a = Integer.parseInt(br.readLine());
			poArr[a]++;
			
		}
		
		StringBuilder sb = new StringBuilder();
				
		for(int i=0; i<=10000; i++) {
			for(int j=1; j<=poArr[i]; j++) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
		br.close();
	}
}
