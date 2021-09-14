package kakao_test;

import java.util.Arrays;


public class Programming1 {

	public static void main(String[] args) {
		
		String[] id_list = {"con", "ryan"};
		String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
		int k = 2;
		
		int n = id_list.length;
		boolean[][] arr = new boolean[n][n];
		
		int[] answer = new int[n];
		
		String[][] report2 = new String[report.length][2];
		
		for(int i=0; i<report.length; i++) {
			report2[i] = report[i].split(" ");
			
			for(int j=0; j<n; j++) {
				if(id_list[j].equals(report2[i][0])) {
					for(int l=0; l<n; l++) {
						if(id_list[l].contentEquals(report2[i][1])) {
							arr[j][l] = true;
							break;
						}
					}
					break;
				}
			}
		}
		
		int[] sum = new int[n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[j][i]) {
					sum[i]++;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(sum[i] >= k) {
				for(int j=0; j<n; j++) {
					if(arr[j][i]) {
						answer[j]++;
					}
				}
			}
		}
		
//		System.out.println(Arrays.toString(answer));
		
	}
}
