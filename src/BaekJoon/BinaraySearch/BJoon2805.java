package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 나무 자르기
 * Created by qkrtjdcjt124
 * Date : 2021/06/23
 */
public class BJoon2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		int start=0, mid, end=0;
		int sum;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
		}
		
		while(start <= end) {
			sum = 0;
			mid = (start+end)/2;
			
			for(int i=0; i<N; i++) {
				sum = (tree[i]-mid) < 0 ? 0 : tree[i]-mid;
			}
			
			System.out.println(sum);
			
			if(sum <= M) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}

}
