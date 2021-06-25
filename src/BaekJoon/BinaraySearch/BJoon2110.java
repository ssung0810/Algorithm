package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 공유기 설치
 * Created by qkrtjdcjf124
 * Date : 2021/06/25
 */
public class BJoon2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(house);
		int result = house[N-1] - house[0];
		int start = 1;
		int end = house[N-1] - house[0];
		int mid = 0;
		int cnt = 0;
		
		while(start <= end) {
			cnt = 1;
			mid = (start+end)/2;
			int prev = house[0];
			
			for(int i=1; i<N; i++) {
				if(mid <= house[i]-prev) {
					prev = house[i];
					cnt++;
				}
			}
			
			if(cnt < C) {
				end = mid - 1;
			} else {
				start = mid + 1;
				result = mid;
			}
		}
		
		System.out.println(result);
	}

}
