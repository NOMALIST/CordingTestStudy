package programmers.practice;

import java.util.Arrays;

public class Lottos {

	public static void main(String[] args) {
		int[] lottos = {1,2,3,4,5,6};
		int[] win_nums = {7,8,9,10,11,12};
		
		int[] answer = solution(lottos, win_nums);
		
		System.out.println(Arrays.toString(answer));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
        Arrays.sort(win_nums);
        System.out.println(Arrays.toString(lottos));
        System.out.println(Arrays.toString(win_nums));
        
        int zeroCount = 0;
        
        for(int i=0; i<lottos.length; i++) {
            if(lottos[i] == 0) zeroCount++;
        }
        
        int lottoIndex = 0;
        int winIndex = 0;
        int sameCount = 0;
        while(lottoIndex < 6 && winIndex < 6) {
            if(lottos[lottoIndex] == win_nums[winIndex]) {
                sameCount++;
                lottoIndex++;
                winIndex++;
                continue;
            } 
            
            if(lottos[lottoIndex] > win_nums[winIndex]) {
                winIndex++;
            } else {
                lottoIndex++;
            }
        }
        
        int[] answer = new int[2];
        answer[1] = 7 - sameCount;
        if(answer[1] > 6) answer[1] = 6;
        answer[0] = 7 - (sameCount + zeroCount);
        if(answer[0] > 6) answer[0] = 6;
        
        return answer;
	}
}
