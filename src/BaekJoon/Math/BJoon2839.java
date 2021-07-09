package BaekJoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 설탕 배달
 * Created by qkrtjdcjf124
 * Date : 2021/07/09
 */
public class BJoon2839 {
	static Integer[] dp = new Integer[5001];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());

		System.out.println(sugar(N, 1));
	}

	static int sugar(int N, int sum) {
		int a=sum, b=sum;
		
		if(dp[N] == null) {
			if(N%3 == 0) {
				a = N/3 + sum;
			} else if(N-3 < 0) {
				a = -1;
			} else  {
				a = sugar(N-3, sum+1);
			}
			
			if(N-5 > 0) {
				b = sugar(N-5, sum+1);
			} else if(N-5 == 0) {
				return b++;
			} else if(N-5 < 0) {
				return -1;
			}
		}
		
		if(a > 0 && b > 0) {
			return Math.min(a, b);
		} else {
			return Math.max(a, b);
		}
	}
}
