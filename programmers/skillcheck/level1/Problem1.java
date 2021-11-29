package programmers.skillcheck.level1;

public class Problem1 {

    private boolean[] decimal = new boolean[3000];

    public int solution(int[] nums) {
        int answer = 0;
        
        decimalCheck();

        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			int sum = nums[i] + nums[j] + nums[k];
        			if(decimal[sum] == false) {
        				answer++;
        			}
        		}
        	}
        }
        

        return answer;
    }
    
    public void decimalCheck() {
        for(int i=2; i<=Math.sqrt(3000); i++) {
            if(!decimal[i]) {
                int mul = 2;
                while(i*mul < 3000) {
                    decimal[i*mul] = true;
                    mul++;
                }
            }
        }
    }
}
