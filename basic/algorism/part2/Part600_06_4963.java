package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Part600_06_4963 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in;
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			in = br.readLine().split(" ");
			int W = Integer.parseInt(in[0]);
			int H = Integer.parseInt(in[1]);
			
			if(W == 0 && H == 0) break;
			
			int[][] arr = new int[H][W];
			int n = 0;
			
			for(int i=0; i<H; i++) {
				in = br.readLine().split(" ");
				for(int j=0; j<W; j++) {
					if(in[j].charAt(0) == '1') {
						arr[i][j] = ++n;
					}
				}
			}
			
			ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
			
			for(int i=0; i<=n; i++) {
				arrList.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					int a, b;
					if((a = arr[i][j]) != 0) {
						if(i + 1 < H && (b = arr[i + 1][j]) != 0) {
							arrList.get(a).add(b);
							arrList.get(b).add(a);
						}
						
						if(j + 1 < W && (b = arr[i][j + 1]) != 0) {
							arrList.get(a).add(b);
							arrList.get(b).add(a);
						}
						
						if(i + 1 < H && j + 1 < W && (b = arr[i + 1][j + 1]) != 0) {
							arrList.get(a).add(b);
							arrList.get(b).add(a);
						}
						
						if(i + 1 < H && j - 1 >= 0 && (b = arr[i + 1][j - 1]) != 0) {
							arrList.get(a).add(b);
							arrList.get(b).add(a);
						}
					}
				}
			}
			
			int ans = 0;
			int[] visited = new int[n + 1];
			Stack<Integer> stack = new Stack<Integer>();
			
			for(int i=1; i<=n; i++) {
				if(visited[i] == 0) {
					ans++;
					
					visited[i] = ans;
					stack.push(i);
					
					while(!stack.isEmpty()) {
						int now = stack.pop();
						
						for(int a : arrList.get(now)) {
							if(visited[a] == 0) {
								visited[a] = ans;
								stack.push(a);
							}
						}
					}
				}
			}
			
			sb.append(ans + "\n");
		}
		
		System.out.println(sb);
		br.close();
	}
}
