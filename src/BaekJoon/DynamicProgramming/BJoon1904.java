package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 01타일(재귀 사용)
 * Created by qkrtjdcjf124
 * Date : 2021/05/04
 */
public class BJoon1904 {
	static int N, cnt, arr[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		arr = new int[N+2];
		Arrays.fill(arr, -1);
		
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		
		System.out.println(tile(N));
	}

	public static int tile(int n) {
		if(arr[n] == -1) {
			arr[n] = (tile(n-1) + tile(n-2)) % 15746;
		}
		
		return arr[n];
	}
}
