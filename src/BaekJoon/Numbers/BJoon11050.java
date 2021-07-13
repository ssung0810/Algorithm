package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 이항 계수 1
 * Created by qkrtjdcjf124
 * Date : 2021/06/07
 */
public class BJoon11050 {
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		dp = new Integer[n+1][r+1];

		System.out.println(Fac(n, r));
	}

	static int Fac(int n, int r) {
		if(n == r || r == 0) return 1;
		
		if(dp[n][r] == null) {
			dp[n][r] = Fac(n-1, r) + Fac(n-1, r-1);
		}
		
		return dp[n][r];
	}
}
