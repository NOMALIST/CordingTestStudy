package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OpenChating {

	public static void main(String[] args) {
		String[] input = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		String[] answer = solution(input);
		
		System.out.println(Arrays.toString(answer));
	}
	
	public static String[] solution(String[] record) {
		
		Map<String, String> nickname = new HashMap<String, String>();
		ArrayList<String[]> log = new ArrayList<String[]>();
		
		
		for(int i=0; i<record.length; i++) {
			String[] temp = record[i].split(" ");
			
			if(temp[0].equals("Enter")) {
				
				nickname.put(temp[1], temp[2]);
				
				String[] a = new String[2];
				a[0] = temp[1];
				a[1] = "님이 들어왔습니다.";
				log.add(a);
				
			} else if(temp[0].equals("Leave")) {
				String[] a = new String[2];
				a[0] = temp[1];
				a[1] = "님이 나갔습니다.";
				log.add(a);
			} else {
				nickname.put(temp[1], temp[2]);
			}
		}
		
		String[] result = new String[log.size()];
		
		for(int i=0; i<log.size(); i++) {
			result[i] = nickname.get(log.get(i)[0]) + log.get(i)[1];
		}
		
		return result;
	}
}
