package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 색종이 만들기
 * Created by qkrtjdcjf124
 * Date : 2021/06/19
 */
public class BJoon2630 {
	static int[][] paper;
	static int white = 0;
	static int blue = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		paper = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0; j<N; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cutting(N, 0, 0);
		
		System.out.println(white);
		System.out.println(blue);
	}

	static void cutting(int N, int row, int col) {
		int check = paper[row][col];
		
		if(N > 1) {
			for(int i=row; i<N+row; i++) {
				for(int j=col; j<N+col; j++) {
					if(check != paper[i][j]) {
						int len = N/2;
						cutting(len, row, col);
						cutting(len, row, col+len);
						cutting(len, row+len, col);
						cutting(len, row+len, col+len);
						
						return;
					}
				}
			}
		}
		
		if(check == 1) blue++;
		else white++;
	}
}
