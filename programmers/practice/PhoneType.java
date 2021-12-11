package programmers.practice;


public class PhoneType {

	public static void main(String[] args) {
		
		String input = "+82-10-6520-6211";

		System.out.println(solution(input));
		
	}
	
	public static int solution(String phone_number) {


		
		if(phone_number.length() == 13) {
			
			if(phone_number.matches("[0-9]{3}-[0-9]{4}-[0-9]{4}")) {
				return 1;
			} 
			
			
		} else if(phone_number.length() == 11) {
			
			if(phone_number.matches("[0-9]{11}")) {
				return 2;
			}
			
			
		} else if(phone_number.length() == 16) {
			
			if(phone_number.matches("\\+82-[0-9]{2}-[0-9]{4}-[0-9]{4}")) {
				
				return 3;
			}
			
		}
		
		return -1;
	}
}
