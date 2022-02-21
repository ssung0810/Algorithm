package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 숫자 카드 2
 * Created by qkrtjdcjf124
 * Date : 2022/02/21
 */
public class BJoon10816 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());
		arr = new int[N];
		st = new StringTokenizer(bf.readLine());

		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		Arrays.sort(arr);

		for(int i=0; i<M; i++) {
			int key = Integer.parseInt(st.nextToken());
			sb.append(upperBound(key) - lowerBound(key) + " ");
		}

		System.out.println(sb);
	}

	static int lowerBound(int key) {
		int st = 0;
		int ed = arr.length;
		int md = 0;

		while(st < ed) {
			md = st + ((ed-st)/2);

			if(arr[md] >= key) {
				ed = md;
			} else {
				st = md + 1;
			}
		}

		return st;
	}

	static int upperBound(int key) {
		int st = 0;
		int ed = arr.length;
		int md = 0;

		while(st < ed) {
			md = st + ((ed-st)/2);

			if(arr[md] <= key) {
				st = md + 1;
			} else {
				ed = md;
			}
		}

		return st;
	}
}
