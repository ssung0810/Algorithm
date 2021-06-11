package BaekJoon.One_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJoon2562 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int n = 0;
		
		for(int i=1; i<=9; i++) {
			int num = Integer.parseInt(bf.readLine());
			if(max < num) {
				max = num;
				n = i;
			}
		}
		
		System.out.println(max);
		System.out.println(n);
	}

}
