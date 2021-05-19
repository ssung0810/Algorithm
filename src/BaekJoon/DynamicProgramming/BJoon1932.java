package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 정수 삼각형
 * Created by qkrtjdcjf124
 * Date : 2021/05/19
 */
public class BJoon1932 {
	static int N, result[], triangle[][];
	static Integer arr[][];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		triangle = new int[N+2][N+2];
		arr = new Integer[N+2][N+2];
		result = new int[N];
		int max = 1;
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=1; j<=max; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
			max++;
		}
		
		arr[1][1] = triangle[1][1];
		arr[2][1] = triangle[1][1] + triangle[2][1];
		arr[2][2] = triangle[1][1] + triangle[2][2];
		
		for(int i=N; i>0; i--) {
			result[i-1] = sum(N, i);
		}
		Arrays.sort(result);
		System.out.println(result[N-1]);
	}
	
	static int sum(int N, int M) {
		if(M <= 0 || M > N) return 0;
		
		if(arr[N][M] == null && M > 0) {
			arr[N][M] = Math.max(triangle[N][M] + sum(N-1, M), triangle[N][M] + sum(N-1, M-1));
		}
		
		return arr[N][M];
	}
}
