package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 동전 0
 * Created By qkrtjdcjf124
 * Date : 2021/05/31
 */
public class BJoon11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());
		int cnt = 0;
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		for(int i=N-1; i>=0; i--) {
			if(goal / arr[i] != 0) {
				cnt += goal / arr[i];
				goal = goal % arr[i];
			}
		}
		
		System.out.println(cnt);
	}

}
