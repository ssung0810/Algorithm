package BaekJoon.BinaraySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 가장 긴 증가하는 부분 수열 2
 * Created by qkrtjdcjf124
 * Date : 2021/07/06
 */
public class BJoon12015 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		
		int N = Integer.parseInt(bf.readLine());
		arr.add(0);
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			int start=0, end=arr.size()-1, mid;
			
			if(arr.get(arr.size()-1) < num) {
				arr.add(num);
			} else {
				while(start <= end) {
					mid = (start+end)/2;
					
					if(arr.get(mid) >= num) {
						if(arr.get(mid-1) < num) {
							arr.set(mid, num);
							break;
						} else {
							end = mid-1;
						}
					} else {
						start = mid+1;
					}
				}
			}
		}
		
		System.out.println(arr.size()-1);
	}
}
