package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Decimal {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		////////////////////////////////
		
		int answer = 1;

        for(int i=3; i<=n; i++) {
            if(decimal(i)) {
            	System.out.println(i);
            	answer++;
            }
        }

        System.out.println(answer);
	}

	static boolean decimal(int N) {
        for(int i=2; i*i<=N; i++) {
            if(N % i == 0) return false;
        }
        
        return true;
    }
}
