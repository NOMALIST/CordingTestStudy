package step_function;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Function_3_1065 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i=1; i<=num; i++) {
			if(func(i)) {
				count++;
			}
		}
		
		bw.write(String.valueOf(count));
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean func(int a) {
		
		String arr = Integer.toString(a);
		
		if(arr.length() <= 2) return true;
		
		int interval = arr.charAt(1) - arr.charAt(0);
		for(int i=1; i<arr.length()-1; i++) {
			if(arr.charAt(i)+interval != arr.charAt(i+1)) {
				return false;
			}
		}
		
		return true;
	}
}
