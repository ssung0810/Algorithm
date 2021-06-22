package BaekJoon.Split;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 종이의 개수
 * Created by qkrtjdcjf124
 * Date : 2021/06/21
 */
public class BJoon1780 {
	static int[][] paper;
	static int m=0, z=0, o=0;

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
		
		cut(N, 0, 0);
		
		System.out.println(m);
		System.out.println(z);
		System.out.println(o);
	}

	static void cut(int N, int x, int y) {
		int check = paper[x][y];
		
		if(N > 1) {
			for(int i=x; i<N+x; i++) {
				for(int j=y; j<N+y; j++) {
					if(check != paper[i][j]) {
						int len = N/3;
						
						cut(len, x, y);
						cut(len, x, y+len);
						cut(len, x, y+len+len);
						cut(len, x+len, y);
						cut(len, x+len, y+len);
						cut(len, x+len, y+len+len);
						cut(len, x+len+len, y);
						cut(len, x+len+len, y+len);
						cut(len, x+len+len, y+len+len);
						
						return;
					}
				}
			}
		}
		
		if(check == -1) m++;
		else if(check == 0) z++;
		else o++;
	}
}
