package step_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class String_9_2941 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		int count = 0;
		boolean isCro;
		for(int i=0; i<str.length(); i++) {
			isCro = false;
			for(String cro : croatia) {
				if(i+cro.length()-1 < str.length()) {
					String a = str.substring(i, i+cro.length());
					if(a.equals(cro)) {
						i += cro.length()-1;
						isCro = true;
						count++;
						break;
					}
				}
			}
			if(!isCro) {
				count++;
			}
		}
		
		System.out.println(count);
		
		br.close();
	}
}
