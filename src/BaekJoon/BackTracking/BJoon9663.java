package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* N-Queen
 * Created by qkrtjdcjf124
 * Date : 2021/07/22
 */
public class BJoon9663 {
	static boolean visit[][];
	static int result = 0, N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		visit = new boolean[N][N];
		
		chess(0);
		
		System.out.println(result);
	}

	static void chess(int D) {
		if(N == D) {
			result++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(QueenCheck(D, i)) {
				visit[D][i] = true;
				chess(D+1);
				visit[D][i] = false;
			}
		}
	}
	
	static boolean QueenCheck(int row, int col) {
		// 세로로 겹치는게 있는지 체크
		for(int i=row; i>=0; i--) {
			if(visit[i][col]) return false;
		}
		
		// 왼쪽 && 위쪽 대각선에 겹치는게 있는지 체크
		for(int i=row, j=col; i>=0 && j>=0; i--,j--) {
			if(visit[i][j]) return false;
		}
		
		// 오른쪽 && 위쪽 대각선에 겹치는게 있는지 체크
		for(int i=row, j=col; i>=0 && j<N; i--,j++) {
			if(visit[i][j]) return false;
		}
		
		return true;
	}
}
