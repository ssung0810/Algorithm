package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 이항 계수 3
 * Created by qkrtjdcjf124
 * Date : 2021/07/13
 */
public class BJoon11401 {
	static Integer[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		dp = new Integer[n+1][k+1];
		
		System.out.println(fac(n, k) % 1000000007);
	}

	static int fac(int n, int k) {
		if(k == 0 || n == k) {
			return 1;
		}
		
		if(dp[n][k] == null) {
			dp[n][k] = fac(n-1, k) + fac(n-1, k-1);
		}
		
		return dp[n][k];
	}
}
