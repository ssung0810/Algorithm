package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 행렬 곱셈
 * Created by qkrtjdcjf124
 * Date : 2021/06/22
 */
public class BJoon2740 {
	static int[][] A, B;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N, M, K;
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(bf.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = new int[M][K];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		pow(N, M, K);
		
		System.out.println(sb);
	}

	static void pow(int N, int M, int K) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<K; j++) {
				int sum = 0;
				for(int l=0; l<M; l++) {
					sum += A[i][l] * B[l][j];
				}
				sb.append(sum + " ");
			}
			sb.append("\n");
		}
	}
}
