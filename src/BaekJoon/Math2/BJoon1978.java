package BaekJoon.Math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 소수 찾기
 * Created by qkrtjdcjf124
 * Date : 2021/07/10
 */
public class BJoon1978 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(decimal(num)) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}

	static boolean decimal(int N) {
		if(N == 1) return false;
		
		for(int i=2; i<=N/2; i++) {
			if(N%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
