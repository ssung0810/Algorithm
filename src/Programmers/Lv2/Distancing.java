package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 거리두기 확인하기
 * Date : 2021/08/11
 */
public class Distancing {
	static Character[][] arr;
	static int[] mx = {1, -1, 0, 0};
	static int[] my = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String[][] places = new String[5][5];
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(bf.readLine());
			
			for(int j=0; j<5; j++) {
				places[i][j] = st.nextToken();
			}
		}
		
		//////////////////////////////////
		
		int[] answer = new int[places.length];
		
		main:
		for(int i=0; i<places.length; i++) {
			arr = new Character[5][5];
			
			for(int m=0; m<5; m++) {
				for(int n=0; n<5; n++) {
					arr[m][n] = places[i][m].charAt(n);
				}
			}
			
			for(int m=0; m<5; m++) {
				for(int n=0; n<5; n++) {
					if(arr[m][n] == 'P') {
						if(!person(m, n, 0)) {
							answer[i] = 0;
							continue main;
						}
					}
				}
			}
			
			answer[i] = 1;
		}
		
		System.out.println(Arrays.toString(answer));
	}

	static boolean person(int m, int n, int d) {
		for(int i=0; i<4; i++) {
			int x = mx[i] + m;
			int y = my[i] + n;
			
			if(x < 0 || y < 0 || x >=5 || y >=5) continue;
			
			if(arr[x][y] == 'P') return false;
			else if(arr[x][y] == 'O' && d == 0) {
				arr[m][n] = 'X';
				
				if(!person(x, y, d+1)) return false;
				else {
					arr[x][y] = 'X';
				}
			}
		}
		
		return true;
	}
}
