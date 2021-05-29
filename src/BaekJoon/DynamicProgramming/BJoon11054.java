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
	static Integer[] r_dp, l_dp;
	static int max=0, num=0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		r_dp = new Integer[N];
		l_dp = new Integer[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			r_cnt(i);
		}
		
		for(int i=N-1; i>=0; i--) {
			l_cnt(i, N-1);
		}
		
		int max = r_dp[0] + l_dp[0];
		for(int i=1; i<N; i++) {
			max = Math.max(max, r_dp[i] + l_dp[i]);
		}
		
		System.out.println(max - 1);
	}

	static int r_cnt(int N) {
		if(r_dp[N] == null) {
			r_dp[N] = 1;
			
			for(int i=N-1; i>=0; i--) { 
				if(arr[N] > arr[i]) {
					r_dp[N] = Math.max(r_dp[N], r_cnt(i) + 1);
				}
			}
		}
		
		return r_dp[N];
	}
	
	static int l_cnt(int N, int num) {
		if(l_dp[N] == null) {
			l_dp[N] = 1;
			
			for(int i=N+1; i<=num; i++) { 
				if(arr[N] > arr[i]) {
					l_dp[N] = Math.max(l_dp[N], l_cnt(i, num) + 1);
				}
			}
		}
		
		return l_dp[N];
	}
}
