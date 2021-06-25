package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 나무 자르기
 * Created by qkrtjdcjt124
 * Date : 2021/06/25
 */
public class BJoon2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] tree = new int[N];
		int start=0, mid=0, end=0;
		long sum=0;
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			end = Math.max(end, tree[i]);
		}
		
		while(sum != M) {
			sum = 0;
			mid = (start+end)/2;
			
			for(int i=0; i<N; i++) {
				if(tree[i] > mid) sum += tree[i] - mid;
			}
			
			if(sum < M) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		
		System.out.println(mid);
	}

}
