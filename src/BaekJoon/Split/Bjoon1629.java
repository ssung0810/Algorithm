package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 곱셈
 * Created by qkrtjdcjf124
 * Date : 2021/07/12
 */
public class Bjoon1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		System.out.println(pow(a, b, c));
		
	}

	static long pow(long a, long b, long c) {
		if(b == 1) {
			return a;
		}
		
//		long temp = pow(a, b/2);
//		
//		if(b % 2 == 1) {
//			return temp * temp * a;
//		}
//		
//		return temp * temp;
		
//		long z = ;
//		System.out.println(z + " :: " + Math.pow(a, b%2) + " :: " + a + " :: " + b);
		return (long) (Math.pow(pow(a, b/2, c), 2) * Math.pow(a, b%2));
	}
}
