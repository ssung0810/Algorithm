package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* K번째의 수
 * Created by qkrtjdcjf124
 * Date : 2021/07/06
 */
public class BJoon1300 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[][] A = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				A[i][j] = i*j;
			}
		}
		
	}

}
