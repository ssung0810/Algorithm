package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N과 M(2)
 * Created by qkrtjdcjf124
 * 2021/05/17
 */
public class BJoon15650 {
	static int N, M, arr[];
	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visit = new boolean[N];
		arr = new int[M];
		
		dfs(0, 0);
		
		System.out.println(sb);
	}

	public static void dfs(int d, int l) {
		if(M == d) {
			for(int val : arr) {
				sb.append(val + " ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
//			if(!visit[i]) {
				visit[i] = true;
				arr[d] = i+1;
				dfs(d+1, i+1);
				visit[i] = false;
//			}
		}
	}
}
