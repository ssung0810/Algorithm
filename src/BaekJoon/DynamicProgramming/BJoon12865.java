package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 평범한 배낭
 * Created by qkrtjdcjf124
 * Date : 2021/07/23
 */
public class BJoon12865 {
	static int[][] bag;
	static int[] dp;
	static int best = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		bag = new int[N][2];
		dp = new int[max+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<=max; i++) {
			BestValue(N, i);
		}
		
		System.out.println(dp[max]);
	}
	
	static void BestValue(int N, int max) {
		for(int i=0; i<N; i++) {
			if(bag[i][0] <= max) {
				dp[max] = Math.max(bag[i][1] + dp[max - bag[i][0]], dp[max]);
			}
		}
		
		
		
//		best = Math.max(best, dp[max]);
	}
}
