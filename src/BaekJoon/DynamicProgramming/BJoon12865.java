package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 평범한 배낭
 * Created by qkrtjdcjf124
 * Date : 2021/05/18
 */
public class BJoon12865 {
	static int[][] bag;
	static int best;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		bag = new int[N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}
		
		BestValue(0, 0, 0, 0, N, max);
		
		System.out.println(best);
	}

	public static void BestValue(int s, int w_sum, int v_sum, int d, int N, int max) {
		if(w_sum > max || d == N) {
			return;
		}
		
		for(int i=s; i<N; i++) {
//			System.out.println(i + " :: " + w_sum + " :: " + v_sum + " :: " + d + " :: " + N + " :: " + max);
			if(w_sum+bag[i][0] <= max) {
				best = Math.max(best, v_sum+bag[i][1]);
				
				BestValue(s+1, w_sum += bag[i][0], v_sum += bag[i][1], d+1, N, max);
				w_sum -= bag[i][0];
				v_sum -= bag[i][1];
			}
			
		}
	}
}
