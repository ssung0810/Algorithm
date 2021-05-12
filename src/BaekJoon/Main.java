package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		dp = new int[41];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(bf.readLine());
			
			if(num == 0) {
				sb.append(1 + " " + 0 + "\n");
			} else if(num == 1) {
				sb.append(0 + " " + 1 + "\n");
			} else {
				sb.append(fibonacci(num-1) + " " + fibonacci(num) + "\n");
			}
		}
		
		System.out.println(sb);
	}

	public static int fibonacci(int n) {
		if(dp[n] == -1) {
			dp[n] = fibonacci(n-1) + fibonacci(n-2);
		}
		
		return dp[n];
	}
}
