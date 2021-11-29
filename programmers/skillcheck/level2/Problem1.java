package programmers.skillcheck.level2;

public class Problem1 {
    public int solution(int n) {
        
        int usage = 0;
        
        while(n > 0) {
            if(n%2 == 1) {
                usage++;
                n--;
            } else {
                n = n/2;
            }
        }

        return usage;
    }
}
