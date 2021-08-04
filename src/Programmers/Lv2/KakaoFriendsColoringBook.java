package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 카카오프렌즈 컬러링북
 * Date : 2021/08/04
 */
public class KakaoFriendsColoringBook {
	static boolean visit[][];
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(bf.readLine());
		int n = Integer.parseInt(bf.readLine());
		int[][] picture = new int[m][n];
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(bf.readLine());
				
			for(int j=0; j<n; j++) {
				picture[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		///////////////////////////////
		
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        visit = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	for(int j=0; j<n; j++) {
        		if(visit[i][j] == false && picture[i][j] != 0) {
        			max = 0;
        			numberOfArea++;
        			visit[i][j] = true;
        			book(m, n, i, j, picture);
        			
        			maxSizeOfOneArea = Math.max(maxSizeOfOneArea, max);
        		}
        	}
        }
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        System.out.println(Arrays.toString(answer));
	}

	static void book(int m, int n, int row, int col, int[][] picture) {
		max++;
		int num = picture[row][col];
		
		// 오른쪽 체크
		if(col+1 < n && visit[row][col+1] == false && picture[row][col+1] == num) {
			visit[row][col+1] = true;
			book(m, n, row, col+1, picture);
		}
		
		// 아래쪽 체크
		if(row+1 < m && visit[row+1][col] == false && picture[row+1][col] == num) {
			visit[row+1][col] = true;
			book(m, n, row+1, col, picture);
		}
		
		// 왼쪽 체크
		if(col-1 >= 0 && visit[row][col-1] == false && picture[row][col-1] == num) {
			visit[row][col-1] = true;
			book(m, n, row, col-1, picture);
		}
		
		// 위쪽 체크
		if(row-1 >= 0 && visit[row-1][col] == false && picture[row-1][col] == num) {
			visit[row-1][col] = true;
			book(m, n, row-1, col, picture);
		}
	}
	
}
