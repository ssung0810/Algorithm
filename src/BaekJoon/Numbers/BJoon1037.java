package BaekJoon.Numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 약수
 * Created by qkrtjdcjf124
 * Date : 2021/06/03
 */
public class BJoon1037 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		if(N % 2 == 1) {
			System.out.println(arr[N/2] * arr[N/2]);
		} else {
			System.out.println(arr[N/2] * arr[N/2-1]);
		}
	}

}
