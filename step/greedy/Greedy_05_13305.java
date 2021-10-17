package step.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Greedy_05_13305 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] node = new int[N];
		int[] edge = new int[N-1];
		
		String[] in = br.readLine().split(" ");
		int i = 0;
		for(String a : in) {
			edge[i++] = Integer.parseInt(a);
		}
		
		in = br.readLine().split(" ");
		i = 0;
		for(String a : in) {
			node[i++] = Integer.parseInt(a);
		}
		
		int minPrice = node[0];
		long total = 0;
		
		for(i=0; i<edge.length; i++) {
			if(node[i] < minPrice) minPrice = node[i];
			total += (long)minPrice * edge[i];
		}
		
		System.out.println(total);
		br.close();
	}
}
