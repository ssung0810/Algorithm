package BaekJoon.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 소수 구하기
 * Created by qkrtjdcjf124
 * Date : 2021/07/10
 */
public class BJoon1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
			
		for(int i=a; i<=b; i++) {
			if(decimal(i)) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
	}

	static boolean decimal(int N) {
		if(N == 1) return false;
		
		for(int i=2; i*i<=N; i++) {
			if(N%i == 0) return false;
		}
		
		return true;
	}
}
