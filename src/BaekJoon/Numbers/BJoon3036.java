package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 링
 * Created by qkrtjdcjf124
 * Date : 2021/06/04
 */
public class BJoon3036 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		
		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b, gcdVal;
		
		for(int i=1; i<N; i++) {
			b = Integer.parseInt(st.nextToken());
			gcdVal = gcd(a, b);
			sb.append(a/gcdVal + "/" + b/gcdVal + "\n");
		}
		
		System.out.println(sb);
	}

	static int gcd(int a, int b) {
		int r;
		
		while(b != 0) {
			r = a % b;
			a = b;
			b = r;
		}
		
		return a;
	}
}
