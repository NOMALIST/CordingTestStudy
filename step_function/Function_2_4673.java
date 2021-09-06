package step_function;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Function_2_4673 {

	public static void main(String[] args) throws IOException{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[10001];
		
		for(int i=1; i<=10000; i++) {
			if(arr[i] != 1) {
				int a = i;
				while((a=selfNumber(a)) <= 10000) {
					arr[a] = 1;
				}
			}
		}
		
		for(int i=1; i<=10000; i++) {
			if(arr[i] != 1) {
				bw.write(String.valueOf(i) + "\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
	
	public static int selfNumber(int a) {
		
		int ans = a;
		int index = 1;
		while(ans/index != 0) {
			ans += a/index - (a/(index*10))*10;
			index *= 10;
		}
		
		return ans;
	}
}
