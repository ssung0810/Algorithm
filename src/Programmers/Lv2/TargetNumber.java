package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 타겟 넘버
 * Date : 2021/08/04
 */
public class TargetNumber {
	static int[] calc = {1, -1};
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int target = Integer.parseInt(bf.readLine());
		
		/////////////////////////
		
		dfs(0, numbers.length, 0, target, numbers);
		
		System.out.println(answer);
	}

	static void dfs(int D, int len, int sum, int target, int[] numbers) {
		if(D == len) {
			if(target == sum) {
				answer++;
			}
			
			return;
		}
		
		for(int i=0; i<2; i++) {
			int num = numbers[D] * calc[i];
			
			dfs(D+1, len, sum+num, target, numbers);
		}
	}
}
