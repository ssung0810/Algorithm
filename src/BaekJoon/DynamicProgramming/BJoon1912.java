package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 연속합
 * Created By qkrtjdcjf124
 * Date : 2021/05/29
 */
public class BJoon1912 {
	static int[] arr;
	static Integer[] dp;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		sum(N-1);
	
		System.out.println(max);
	}

	static int sum(int N) {
		if(dp[N] == null) {
			dp[N] = Math.max(arr[N] + sum(N-1), arr[N]);
		}
		max = Math.max(max, dp[N]);
		
		return dp[N];
	}
}
