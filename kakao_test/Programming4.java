package kakao_test;

import java.util.Arrays;

public class Programming4 {

	public static void main(String[] args) {
		
		int n = 5;
		int[] info = {0,0,0,0,0,0,0,0,0,0,5};
		int[] answer;
		
		int leftArrow = n;
		int[] lion = new int[11];
		int maxGap = 0;
		int[] maxGapArrow = new int[11];
		for(int ten = n; ten>=0; ten--) {
			leftArrow = n - ten;
			lion[0] = ten;
			for(int nine = leftArrow; nine>=0; nine--) {
				leftArrow -= nine;
				lion[1] = nine;
				for(int eight = leftArrow; eight>=0; eight--) {
					leftArrow -= eight;
					lion[2] = eight;
					for(int seven = leftArrow; seven>=0; seven--) {
						leftArrow -= seven;
						lion[3] = seven;
						for(int six = leftArrow; six>=0; six--) {
							leftArrow -= six;
							lion[4] = six;
							for(int five = leftArrow; five>=0; five--) {
								leftArrow -= five;
								lion[5] = five;
								for(int four = leftArrow; four>=0; four--) {
									leftArrow -= four;
									lion[6] = four;
									for(int three = leftArrow; three>=0; three--) {
										leftArrow -= three;
										lion[7] = three;
										for(int two = leftArrow; two>=0; two--) {
											leftArrow -= two;
											lion[8] = two;
											for(int one = leftArrow; one>=0; one--) {
												leftArrow -= one;
												lion[9] = one;

												int zero = leftArrow;
												lion[10] = zero;
												
												int lionPoint = 0;
												int apeachPoint = 0;
												for(int i=0; i<=10; i++) {
													if(info[i] + lion[i] == 0) {
														continue;
													}
													
													if(info[i] >= lion[i]) {
														apeachPoint += (10-i);
													} else {
														lionPoint += (10-i);
													}
												}
												
												int gap = lionPoint - apeachPoint;
												
												if(maxGap < gap) {
													maxGap = gap;
													for(int i=0; i<=10; i++) {
														maxGapArrow[i] = lion[i];
													}
												} else if(maxGap == gap && gap > 0) {
													int a = 0, b = 0;
													
													for(int i=0; i<=10; i++) {
														a += (10 - i)*maxGapArrow[i];
														b += (10 - i)*lion[i];
													}
													
													if(a > b) {
														for(int i=0; i<=10; i++) {
															maxGapArrow[i] = lion[i];
														}
													}
												}
												
												leftArrow += one;
												
											}
											leftArrow += two;
										}
										leftArrow += three;
									}
									leftArrow += four;
								}
								leftArrow += five;
							}
							leftArrow += six;
						}
						leftArrow += seven;
					}
					leftArrow += eight;
				}
				leftArrow += nine;
			}
			
		}
		
		if(maxGap == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = maxGapArrow;
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
