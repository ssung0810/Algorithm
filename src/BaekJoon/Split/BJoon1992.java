package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 쿼드트리
 * Created by qkrtjdcjf124
 * Date : 2021/06/21
 */
public class BJoon1992 {
	static int[][] movie;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		movie = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String[] txt = bf.readLine().split("");
			for(int j=0; j<N; j++) {
				movie[i][j] = Integer.parseInt(txt[j]);
			}
		}
		
		sb.append(cut(N, 0, 0));
		
		System.out.println(sb);
	}

	static String cut(int N, int row, int col) {
		int check = movie[row][col];
		
		if(N > 1) {
			for(int i=row; i<N+row; i++) {
				for(int j=col; j<N+col; j++) {
					if(check != movie[i][j]) {
						sb.append("(");
						int len = N/2;
						
						sb.append(cut(len, row, col));
						sb.append(cut(len, row, col+len));
						sb.append(cut(len, row+len, col));
						sb.append(cut(len, row+len, col+len));
						
						return ")";
					}
				}
			}
		}
		
		return Integer.toString(check);
	}
}
