package programmers.practice;

import java.util.Arrays;
import java.util.LinkedList;

public class ColoringBook {

	static int M;
	static int N;
	static boolean[][] check;
	
	public static void main(String[] args) {
	
		int[][] input = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		
		System.out.println(Arrays.toString(solution(6, 4, input)));
	}
	
	 public static int[] solution(int m, int n, int[][] picture) {
		 
		int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        


        M = m;
        N = n;
        check = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(!check[i][j] && picture[i][j] != 0) {
        			int size = findArea(i, j, picture);
        			numberOfArea++;
        			
        			if(size > maxSizeOfOneArea) maxSizeOfOneArea = size;
        		}
        	}
        }
        

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
	 }
	 
	 public static int findArea(int r, int c, int[][] picture) {
		 
		 int color = picture[r][c];
		 int countSize = 0;
		 
		 LinkedList<int[]> que = new LinkedList<int[]>();
		 int[] start = {r, c};
		 check[r][c] = true;
		 countSize++;
		 que.add(start);
		 
		 int[][] move = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		 while(!que.isEmpty()) {
			 int[] now = que.poll();
			 
			 for(int[] t : move) {
				 int nextR = now[0] + t[0];
				 int nextC = now[1] + t[1];
				 
				 if(nextR >= 0 && nextR < M && nextC >= 0 && nextC < N) {
					 if(picture[nextR][nextC] == color && !check[nextR][nextC]) {
						 int[] temp = {nextR, nextC};
						 check[nextR][nextC] = true;
						 que.add(temp);
						 countSize++;
					 }
				 }
			 }
		 }
		 
		 return countSize;
	 }
}
