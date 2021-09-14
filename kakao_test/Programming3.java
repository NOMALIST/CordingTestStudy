package kakao_test;

import java.util.Arrays;

public class Programming3 {

	public static void main(String[] args) {
		int[] fees = {180, 5000, 10, 600};
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] answer;
		
		
		int[][] parking = new int[10000][2];
		int[] time = new int[10000];
		
		for(int i=0; i<records.length; i++) {
			String inout = records[i].substring(11);
			int hh = (records[i].charAt(0)-'0')*10 + (records[i].charAt(1)-'0');
			int mm = (records[i].charAt(3)-'0')*10 + (records[i].charAt(4)-'0');
			int carNumber = (records[i].charAt(6) - '0')*1000 + (records[i].charAt(7) - '0')*100 + (records[i].charAt(8) - '0')*10 + (records[i].charAt(9) - '0');
			
			if(inout.equals("IN")) {	// 입차 할 때
				parking[carNumber][0] = hh*100 + mm;
				parking[carNumber][1] = -1;
			} else {	// 출차 할 때
				int inTime = parking[carNumber][0];
				
				parking[carNumber][1] = hh*100 + mm;
				
				if(hh == inTime/100) {	// 입출차 시가 같을때
					time[carNumber] += (mm - inTime%100);
				} else {	// 입출차 시가 다를때
					time[carNumber] += (60-(inTime%100));
					time[carNumber] += (hh - inTime/100 - 1) * 60;
					time[carNumber] += mm;
				}
			}
		}
		
		// 출차 안한 차량 출차 처리(23:59)
		for(int i=0; i<10000; i++) {
			if(parking[i][1] == -1) {
				int hh = 23;
				int mm = 59;
				
				int inTime = parking[i][0];
				
				parking[i][1] = hh*100 + mm;
				
				if(hh == inTime/100) {	// 입출차 시가 같을때
					time[i] += (mm - inTime%100);
				} else {	// 입출차 시가 다를때
					time[i] += (60-(inTime%100));
					time[i] += (hh - inTime/100 - 1) * 60;
					time[i] += mm;
				}
			}
		}
		
		// 요금 계산
		int[] payments = new int[10000];
		int paymentIndex = 0;
		for(int i=0; i<10000; i++) {
			if(time[i] > 0) {
				int cost = fees[1];
				time[i] -= fees[0];
				if(time[i] > 0) {
					cost += (int)Math.ceil(time[i] / (double)fees[2]) * fees[3];
				}
				payments[paymentIndex++] = cost;
			}
		}
		
		
		answer = new int[paymentIndex];
		for(int i=0; i<paymentIndex; i++) {
			answer[i] = payments[i];
		}
		
		
		System.out.println(Arrays.toString(answer));
		
	}
}
