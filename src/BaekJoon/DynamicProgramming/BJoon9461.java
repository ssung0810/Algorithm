package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 파도반 수열
 * 
 */
public class BJoon9461 {
	static long[] dp = new long[101];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		
		for(int i=0; i<N; i++) {
			sb.append(wave(Integer.parseInt(bf.readLine())) + "\n");
		}
		
		System.out.println(sb);
	}

	static long wave(int n) {
		if(dp[n] == 0) {
			dp[n] = wave(n-1) + wave(n-5);
		}
		
		return dp[n];
	}
}
