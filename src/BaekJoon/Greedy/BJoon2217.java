package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 로프
 * Date : 2021/08/10
 */
public class BJoon2217 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}
		
		Arrays.sort(arr);
		
		int max = arr[0] * N;
		for(int i=1; i<N; i++) {
			int num = arr[i] * (N-i);
			
			if(max < num) max = num;
		}
		
		System.out.println(max);
	}

}
