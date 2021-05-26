package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 가장 긴 바이토닉 부분 수열
 * Created by qkrtjdcjf124
 * Date : 2021/05/26
 */
public class BJoon11054 {
	static int[] arr;
	static Integer[] dp;
	static int max=0, num=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			longest(i);
		}
		
		for(int i=num+1; i<N; i++) {
			dp[i] = null;
		}
		
		for(int i=num+1; i<N; i++) {
			shortest(i);
		}

		System.out.println(max);
	}

	static int longest(int N) {
		if(dp[N] == null) {
			dp[N] = 1;
			
			for(int i=N-1; i>=0; i--) { 
				if(arr[N] > arr[i]) {
					dp[N] = Math.max(dp[N], longest(i) + 1);
				}
			}
			
			if(max < dp[N]) {
				max = dp[N];
				num = N;
			}
		}
		
		return dp[N];
	}
	
	static int shortest(int N) {
		if(dp[N] == null) {
			dp[N] = 1;
			
			for(int i=N-1; i>=num; i--) { 
				if(arr[N] < arr[i]) {
					dp[N] = Math.max(dp[N], shortest(i) + 1);
				}
			}
			max = Math.max(max, dp[N]);
		}
		
		return dp[N];
	}
}
