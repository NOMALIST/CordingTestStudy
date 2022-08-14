package step_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * N명의 점수를 받아와 k명이 상을 받을때 컷트라인 점수를 구하는 문제
 * @author YOJUIN SEO
 *
 */
public class Sort_25305_Cutline {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int N  = Integer.parseInt(input.split(" ")[0]);
		int K  = Integer.parseInt(input.split(" ")[1]);
		
		input = br.readLine();
		String[] scoreString = input.split(" ");
		Integer[] score = new Integer[N];
		
		
		for(int i=0; i<N; i++) {
			score[i] = Integer.parseInt(scoreString[i]);
		}
		
		Arrays.sort(score, Comparator.reverseOrder());
		
		System.out.println(score[K-1]);
		
		
		br.close();
	}
	
}
