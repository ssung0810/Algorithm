package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 이항 계수 1
 * Created by qkrtjdcjf124
 * Date : 2021/06/07
 */
public class BJoon11050 {
	static Integer[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		dp = new Integer[n+1];

		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		
		System.out.println(Fac(n) / (Fac(n-r)*Fac(r)) );
		System.out.println(Fac(5));
	}

	static int Fac(int N) {
		if(N < 0) return 1;
		
		if(dp[N] == null) {
			dp[N] = N * Fac(N-1);
		}
		
		return dp[N];
	}
}
