package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 랜선 자르기
 * Created by qkrtjdcjf124
 * Date : 2021/06/23
 */
public class BJoon1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] line = new int[K];
		int sum = 0;
		long start=1, mid, end=0;
		
		for(int i=0; i<K; i++) {
			line[i] = Integer.parseInt(bf.readLine());
			end = Math.max(line[i], end);
		}
		
		while(start <= end) {
			sum = 0;
			mid = (end+start)/2;
			
			for(int i=0; i<K; i++) {
				sum += line[i]/mid;
			}
			
			if(sum >= N) {
				start = mid + 1;
			} else if(sum < N) {
				end = mid - 1;
			}
		}
		
		System.out.println(end);
	}
}
