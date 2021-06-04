package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 최소공배수
 * Created by qkrtjdcjf124
 * Date : 2021/06/04
 */
public class BJoon1934 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int a = A;
			int b = B;
			int c;
			
			while(a%b != 0) {
				c = a % b;
				a = b;
				b = c;
			}
			
			sb.append(A*B/b + "\n");
		}
		
		System.out.println(sb);
	}

}
