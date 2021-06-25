package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* K번째의 수
 * Created by qkrtjdcjf124
 * Date : 2021/06/25
 */
public class BJoon1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		long[] B = new long[N*N+1];
		long cnt = 1000000000L;
		
		B[(int)cnt] = 1;
		
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				B[cnt] = i*j;
//			}
//		}
	}

}
