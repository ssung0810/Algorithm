package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* RGB거리
 * Created by qkrtjdcjf124
 * Date : 2021/05/20
 */
public class BJoon1149 {
	static int[][] rgb;
	static int[][] arr;
	static int[] num = {1, 2, 3};

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		rgb = new int[N+1][4];
		arr = new int[N+1][4];
		int[] result = new int[3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(bf.readLine());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
			rgb[i][3] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=3; i>0; i--) {
			result[i-1] = home(N, i);
		}

		Arrays.sort(result);
		System.out.println(result[0]);
	}
	
	static int home(int N, int i) {
		if(arr[N][i] == 0) {
			if(N == 1) {
				arr[N][i] = rgb[N][i];
			} else if(i == 1) { 
				arr[N][i] = rgb[N][i] + Math.min(home(N-1, 2), home(N-1, 3));
			} else if(i == 2) {
				arr[N][i] = rgb[N][i] + Math.min(home(N-1, 1), home(N-1, 3));
			} else if(i == 3) {
				arr[N][i] = rgb[N][i] + Math.min(home(N-1, 1), home(N-1, 2));
			}
		}
		
		return arr[N][i];
	}
}
