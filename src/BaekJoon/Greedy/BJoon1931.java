package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 회의실 배정
 * Created by qkrtjdcjf124
 * Date : 2021/05/31
 */
public class BJoon1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[][] meet = new int[N][2];
		int cnt, point;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			meet[i][0] = Integer.parseInt(st.nextToken());
			meet[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meet, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2)  {
				if(e1[1] == e2[1]) {
					return e1[0] - e2[0];
				} else {
					return e1[1] - e2[1];
				}
			}
		});
		
		point = meet[0][1];
		cnt = 1;
		for(int i=1; i<N; i++) {
			if(meet[i][0] >= point) {
				point = meet[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
