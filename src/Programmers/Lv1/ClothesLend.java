package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ClothesLend {
	static int[] dp;
    static int[] member;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		
		
		int a = Integer.parseInt(bf.readLine());
		int[] lost = new int[a];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<a; i++) {
			lost[i] = Integer.parseInt(st.nextToken());
		}
		
		int b = Integer.parseInt(bf.readLine());
		int[] reserve = new int[b];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<b; i++) {
			reserve[i] = Integer.parseInt(st.nextToken());
		}
		
		////////////////////////////////////
		
		int answer = 0;
		member = new int[n+2];
        dp = new int[n+2];
        
        for(int i=0; i<lost.length; i++) {
            member[lost[i]] = -1;
        }
        
        if(reserve.length == 1) {
        	if(member[reserve[0] - 1] == -1 || member[reserve[0] + 1] == -1) answer = 1;
        } else {
        	answer = lend(0, 0, reserve);
        }
        
        System.out.println(answer+ (n-lost.length));
	}

	static int lend(int N, int num, int[] res) {
//		System.out.println(N + " :: " + num + " :: " + res.length);
        if(N+1 > res.length) return 1;
        
        if(dp[res[N]] == 0) {
            int a=0, b=0;
            
            if(member[res[N]-1] == -1 && res[N]-1 != num) {
                a = 1 + lend(N+1, res[N]-1, res);
            }
            if(member[res[N]+1] == -1 && res[N]+1 != num) {
                b = 1 + lend(N+1, res[N]+1, res);
            }
            
            dp[res[N]] = Math.max(a, b);
        }
        
        return dp[res[N]];
    }
}
