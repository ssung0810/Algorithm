package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 소수 만들기
 * Date : 2021/07/23
 */
public class MakeDecimal {
	static int answer;
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		int[] nums = new int[N];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		///////////////////////////////
		
		int len = nums.length;
		visit = new boolean[len];
		make(len, 0, 0, nums);
		
		System.out.println(answer);
	}

	static void make(int N, int D, int s, int[] nums) {
		if(3 == D) {
			decimal(N, nums);
			return;
		}
		
		for(int i=s; i<N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				make(N, D+1, i+1, nums);
				visit[i] = false;
			}
		}
	}
	
	static void decimal(int N, int[] nums) {
		int sum = 0;
		
		for(int i=0; i<nums.length; i++) {
			if(visit[i]) {
				sum += nums[i];
			}
		}
		
		for(int i=2; i*i<=sum; i++) {
			if(sum % i == 0) return;
		}
		
		answer++;
	}
}
