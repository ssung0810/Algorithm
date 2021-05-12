package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJoon2156 {
	static int N, wine[], max=0;
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(bf.readLine());
		
		wine = new int[N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			wine[i] = Integer.parseInt(bf.readLine());
		}
		
		manyEats(1, 0, 0);
		
		System.out.println(max);
	}

	public static void manyEats(int cnt, int sum, int start) {
		int c = cnt;
		
		for(int i=start; i<N; i++) {
			int s = sum;
			
			if(c == 3) {
				c = 1;
				continue;
			}
			
			s += wine[i];
			c++;
			manyEats(c, s, i+1);
			
			c = 1;
		}
		
		if(max < sum) max = sum;
	}
}
