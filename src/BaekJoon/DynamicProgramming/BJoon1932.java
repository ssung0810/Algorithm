package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* 정수 삼각형
 * Created by qkrtjdcjf124
 * Date : 2021/05/04
 * 
 */
public class BJoon1932 {
	static int N, triangle[][];
	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(bf.readLine());
		triangle = new int[N][N];
		int max = 1;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<max; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
			max++;
		}
		
		sumDFS(0, triangle[0][0], 0);
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));
	}

	public static void sumDFS(int s, int sum, int d) {
		int r;
		
		for(int i=s; i<=s+1; i++) {
			if(i < N) {
				r = sum + triangle[d+1][i];
				
				if(d == N-2) {
					result.add(r);
				} else {
					sumDFS(i, r, d+1);
				}
			}
		}
	}
}
