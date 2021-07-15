package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 피보나치 수 6
 * Created by qkrtjdcjf124
 * Date : 2021/07/14
 */
public class BJoon11444 {
	static int div = 1000000007;
	

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		System.out.println(fib(N));
	}

	static int fib(int N) {
		if(N == 0) return 0;
		else if(N == 1) return 1;
		
		return ((fib(N-1) % div) + (fib(N-2) % div)) % div;
	}
}
