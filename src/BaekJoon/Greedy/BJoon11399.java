package BaekJoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* ATM
 * Created by qkrtjdcjf124
 * Date : 2021/06/01
 */
public class BJoon11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] time = new int[N];
		int sum = 0;
		
		st = new StringTokenizer(bf.readLine(), " ");
		for(int i=0; i<N; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(time);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum += time[j];
			}
		}
		
		System.out.println(sum);
	}
}
