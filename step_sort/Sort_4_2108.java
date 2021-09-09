package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort_4_2108 {

	public static int[] poArr = new int[4001];
	public static int[] neArr = new int[4001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int a;
		int min = 9999, max = -9999;
		
		// 카운팅 정렬 사용
		for(int i = 1; i<=n; i++) {
			a = Integer.parseInt(br.readLine());
			
			if(a>=0) {
				poArr[a]++;
			} else {
				neArr[a * -1]++;
			}
			
			if(a < min) min = a;
			if(a > max) max = a;
			
			sum += a;
		}
		
		int avg = (int) Math.round((double) sum/n);
		int range = max - min;
		
		int mode = -9999; // 최빈값
		int modeNumber = 0; // 최빈값 횟수
		boolean isModeSecondary = false;	// 최빈값이 여러개일때, 두번째 인지? t=두번째임, f=두번째 아님
		int now = 0;	// 중앙값 탐색을 위한 인덱스
		int mid = -9999;	// 중앙값

		// 음수 영역 탐색
		for(int i=4000; i>0; i--) {
			if(now <= n/2 && n/2 <= now + neArr[i]) {
				mid = i * -1;
			}
			
			if(neArr[i] > modeNumber) {
				mode = i * -1;
				modeNumber = neArr[i];
				isModeSecondary = false;
			} else if(neArr[i] == modeNumber && !isModeSecondary) {
				mode = i * - 1;
				isModeSecondary = true;
			}
			now += neArr[i];
		}
		
		// 양수 영역 탐색
		for(int i=0; i<=4000; i++) {
			if(now <= n/2 && n/2 <= now + poArr[i]) {
				mid = i;
			}
			
			if(poArr[i] > modeNumber) {
				mode = i;
				modeNumber = poArr[i];
				isModeSecondary = false;
			} else if(poArr[i] == modeNumber && !isModeSecondary) {
				mode = i;
				isModeSecondary = true;
			}
			now += poArr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(avg + "\n");
		sb.append(mid + "\n");
		sb.append(mode + "\n");
		sb.append(range);
		
		System.out.println(sb);
		br.close();
	}
}
