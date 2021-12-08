package programmers.practice;

public class StringCompression {

	public static void main(String[] args) {
		
		String s = "xababcdcdababcdcd";
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int answer = s.length();
        
        for(int i=1; i<=s.length() / 2; i++) {
            int result = reducingString(s, i);
            if(result < answer) answer = result;
        }
        
        return answer;
	}
	
	public static int reducingString(String s, int divNumber) {
		int length = 0;
        int repeatTime = 1;
        for(int i=divNumber; i + divNumber - 1<s.length(); i+=divNumber) {
            if(s.substring(i - divNumber, i).equals(s.substring(i, i + divNumber)) ) {
            	repeatTime++;
            } else {
            	if(repeatTime != 1) length += String.valueOf(repeatTime).length();
            	length += divNumber;
            	repeatTime = 1;
            }
        }	
        
        if(repeatTime != 1) length += String.valueOf(repeatTime).length();
        length += divNumber;
        
        length += s.length() % divNumber;
        
        return length;
	}
}
