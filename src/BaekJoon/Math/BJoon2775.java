package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 부녀회장이 될테야
 * Created by qkrtjdcjf124
 * Date : 2021/07/09
 */
public class BJoon2775 {
	static int[][] dp = new int[15][15];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int k,n;
		
		for(int i=0; i<N; i++) {
			k = Integer.parseInt(bf.readLine());
			n = Integer.parseInt(bf.readLine());
			
			sb.append(floor(k, n) + "\n");
		}
		
		System.out.println(sb);
	}

	static int floor(int k, int n) {
		if(k == 0) {
			return n;
		} else if(n == 1) {
			return 1;
		}
		
		if(dp[k][n] == 0) {
			dp[k][n] = floor(k-1, n) + floor(k, n-1);
		}
		
		return dp[k][n];
	}
}
