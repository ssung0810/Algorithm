package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
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

		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			int start = 0;
			int end = A.length - 1;
			int mid = 0;
			int result = 0;

			while(start <= end) {
				mid = (start + end) / 2;

				if(A[mid] == num) {
					result = 1;
					break;
				} else if(A[mid] < num) {
					start = mid+1;
				} else if(A[mid] > num) {
					end = mid-1;
				}
			}

			sb.append(result + "\n");
		}

		System.out.println(sb);
	}

}
