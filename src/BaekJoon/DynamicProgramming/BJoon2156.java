package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJoon2156 {
	static int[] wine;
	static Integer arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		wine = new int[N+1];
		arr = new Integer[N+1];
		
		for(int i=1; i<=N; i++) {
			wine[i] = Integer.parseInt(bf.readLine());
		}
		
		arr[0] = 0;
		arr[1] = wine[1];
		if(N > 1) arr[2] = wine[1] + wine[2];
		
		System.out.println(Math.max(sum(N), sum(N-1)));
	}

	static int sum(int N) {
		if(arr[N] == null) {
			arr[N] = Math.max(sum(N-2), sum(N-3) + wine[N-1]) + wine[N];
		}
		
		return arr[N];
	}
}
