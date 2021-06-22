package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 수 찾기
 * Created by qkrtjdcjf124
 * Date : 2021/06/22
 */
public class BJoon1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(bf.readLine());
		int[] A = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		
		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());
		while(M-- > 0) {
			int num = Integer.parseInt(st.nextToken());
			int cnt = 0;
			int start = 0;
			int end = A.length - 1;
			int mid = (end+start) / 2;

			while(end-start >= 0) {
				if(A[mid] == num) {
					cnt = 1;
					break;
				} else if(A[mid] > num) {
					end = mid-1;
				} else if(A[mid] < num) {
					start = mid+1;
				}
				
				mid = (end+start) / 2;
			}
			
			sb.append(cnt + "\n");
		}
		
		System.out.println(sb);
	}

}
