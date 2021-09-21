package basic.algorism.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Part400_14_2225 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int K = Integer.parseInt(input[1]);
		
		// long[x][y]는 x개의 수로 y의 값이 나오는 경우의 수를 저장
		long[][] arr = new long[K+1][N+1];
		
		arr[0][0] = 1;
		
		for(int i=1; i<=K; i++) {	// i번째 정수
			for(int j=0; j<=N; j++) {	// i-1번째 까지의 합이 j일때
				for(int k=0; j+k<=N; k++) {	// i번째로 선택한 수 k
					arr[i][j + k] = (arr[i][j + k] + arr[i - 1][j]) % 1000000000;
				}
			}
		}
		
		System.out.println(arr[K][N]);
		br.close();
		
	}
}
