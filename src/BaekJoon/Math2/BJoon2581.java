package BaekJoon.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 소수
 * Created by qkrtjdcjf124
 * Date : 2021/07/10
 */
public class BJoon2581 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(bf.readLine());
		int N = Integer.parseInt(bf.readLine());
		int sum = 0;
		int min = 10001;
			
		for(int i=M; i<=N; i++) {
			if(decimal(i)) {
				sum += i;
				min = Math.min(min, i);
			}
		}
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}

	static boolean decimal(int N) {
		if(N == 1) return false;
		
		for(int i=2; i*i<=N; i++) {
			if(N%i == 0) return false;
		}
		
		return true;
	}
}
