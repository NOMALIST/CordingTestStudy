import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


import java.io.IOException;
 
public class Test {
 
	public static void main(String[] args) throws IOException {
 
		String S = "abab";
		int answer = 0;
		ArrayList<Integer> block = new ArrayList<Integer>();
		
		S = S + "c";
		System.out.println(S);
		
		for(int i=1; i<S.length(); i++) {
			int length = 1;
            if(S.charAt(i) != S.charAt(i-1)) {
                answer++;
            }
        }
		int N = Math.abs(1 - 1000);
		
		System.out.println(N);
	}
 
 
}