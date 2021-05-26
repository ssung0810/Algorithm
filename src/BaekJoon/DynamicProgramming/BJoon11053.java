package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열
 * Created by qkrtjdcjf124
 * Date : 2021-05-21
 */
public class BJoon11053 {
	static int[] arr;
	static Integer[] dp;

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
		
		Arrays.sort(dp);
		System.out.println(dp[N-1]);
	}

	static int longest(int N) {
		if(dp[N] == null) {
			dp[N] = 1;
			
			for(int i=N-1; i>=0; i--) {
				if(arr[i] < arr[N]) {
					dp[N] = Math.max(dp[N], longest(i) + 1);
				}
			}
		}
		
		return dp[N];
	}
}
