package step.essence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Essence_02_1037 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			numbers.add(Integer.parseInt(input[i]));
		}
		
		Collections.sort(numbers);
		
		
		System.out.println(numbers.get(0) * numbers.get(numbers.size()-1));
		br.close();
	}
}
