package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJoon2579 {
	static int[] dp, arr;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.fill(dp, -1);
		
		dp[0] = 0;
		dp[1] = arr[1];
		if(N > 1) dp[2] = arr[1] + arr[2];
		
		System.out.println(find(N));
	}

	static int find(int N) {
		if(dp[N] == -1) {
			dp[N] = Math.max(find(N - 2), find(N - 3) + arr[N - 1]) + arr[N];
		}
		
		return dp[N];
	}
}
