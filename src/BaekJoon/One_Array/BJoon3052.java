package BaekJoon.One_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJoon3052 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[42];
		int cnt = 0;
		
		for(int i=0; i<10; i++) {
			int num = Integer.parseInt(bf.readLine());
			arr[num%42]++;
		}
		
		for(int i=0; i<42; i++) {
			if(arr[i] > 0) cnt++;
		}
		
		System.out.println(cnt);
	}

}
