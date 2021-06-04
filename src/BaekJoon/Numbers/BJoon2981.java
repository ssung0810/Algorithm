package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 검문
 * Created by qkrtjdcjf124
 * Date : 2021/06/04
 */
public class BJoon2981 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		Arrays.sort(arr);

		int val = arr[1] - arr[0];
		for(int i=2; i<N; i++) {
			val = gcd(val, arr[i] - arr[i-1]);
		}
		
		for(int i=2; i<=val/2; i++) {
			if(val % i == 0) sb.append(i + " ");
		}
		sb.append(val);
		
		System.out.println(sb);
	}
	
	static int gcd(int a, int b) {
		int r;
		while(a != 0) {
			r = b % a;
			b = a;
			a = r;
		}
		
		return b;
	}
}
