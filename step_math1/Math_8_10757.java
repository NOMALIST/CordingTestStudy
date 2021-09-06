package step_math1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Math_8_10757 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String numString1 = st.nextToken();
		String numString2 = st.nextToken();
		
		int[] num1 = new int[10001]; 
		int[] num2 = new int[10001]; 
		int[] sum = new int[10002];
		
		int len1 = numString1.length();
		for(int i=len1-1; i>=0; i--) {
			num1[len1-i] = numString1.charAt(i) - '0';
		}
		
		int len2 = numString2.length();
		for(int i=len2-1; i>=0; i--) {
			num2[len2-i] = numString2.charAt(i) - '0';
		}
		
		int index=1;
		while(index <= len1 || index <= len2) {
			if(index <= len1 && index <= len2) {
				sum[index] += num1[index] + num2[index];
			} else if(index <= len1) {
				sum[index] += num1[index];
			} else if(index <= len2) {
				sum[index] += num2[index];
			}
			
			if(sum[index] >= 10) {
				sum[index] = sum[index]%10;
				sum[index+1]++;
			}
			
			index++;
		}
		
		if(sum[index] == 0) index--;
		
		for(int i=index; i>=1; i--) {
			bw.write(String.valueOf(sum[i]));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
