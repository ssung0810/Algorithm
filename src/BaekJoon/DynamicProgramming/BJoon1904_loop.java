package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 01타일(반복문 사용)
 * Created by qkrtjdcjf124
 * Date : 2021/05/04
 */
public class BJoon1904_loop {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		
		int a = 1;
		int b = 2;
		int sum = 0;
		
		if(N == 1) {
			System.out.println(1);
			return;
		} else if(N == 2) {
			System.out.println(2);
			return;
		}
		
		for(int i=3; i<=N; i++) {
			sum = (a+b) % 15746;
			a = b;
			b = sum;
		}
		
		System.out.println(sum);
	}
}
