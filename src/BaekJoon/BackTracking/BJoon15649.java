package BaekJoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* N과 M(1)
 * Created by qkrtjdcjf124
 * 2021/05/17
 */
public class BJoon15649 {
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
		
		dfs(0);
		
		System.out.println(sb);
	}
	
	public static void dfs(int d) {
		for(int i=0; i<N; i++) {
			if(visit[i] == false) {
				visit[i] = true;
				arr[d] = i+1;
				
				if((d+1) < M) {
					dfs(d+1);
				} else if((d+1) == M) {
					for(int j=0; j<arr.length; j++) {
						sb.append(arr[j] + " ");
					}
					sb.append("\n");
				}
				
				visit[i] = false;
			}
		}
	}
}
