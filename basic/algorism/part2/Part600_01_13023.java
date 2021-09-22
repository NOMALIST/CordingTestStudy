package basic.algorism.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Part600_01_13023 {

	private static boolean ans;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			arrList.add(new ArrayList<Integer>());
		}
		
		for(int i=1; i<=M; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			
			arrList.get(a).add(b);
			arrList.get(b).add(a);
		}
		
		boolean[] visited = new boolean[N];
		
		for(int i=0; i<N; i++) {
			visited[i] = true;
			dfs(i, arrList, visited, 1);
			visited[i] = false;
		}
		
		if(ans) System.out.println(1);
		else System.out.println(0);
		
		br.close();
		
	}
	
	public static void dfs(int now, ArrayList<ArrayList<Integer>> arrList, boolean[] visited, int depth) {
		
		if(depth == 5) {
			ans = true;
			return;
		}
		
		for(int i : arrList.get(now)) {
			if(ans) {
				break;
			}
			
			if(!visited[i]) {
				visited[i] = true;
				dfs(i, arrList, visited, depth+1);
				visited[i] = false;
			}
		}
	}
	
}
