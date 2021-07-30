package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 비밀지도
 * Date : 2021/07/30
 */
public class SecretMap_kakao {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(bf.readLine());
		int[] arr1 = new int[5];
		int[] arr2 = new int[5];
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		
		////////////////////////////////
		
		String[] answer = new String[n];
		
		int[][] map1 = new int[n][n];
		for(int i=0; i<arr1.length; i++) {
			String txt = secret(arr1[i], n);
			
			for(int j=0; j<txt.length(); j++) {
				map1[i][j] = txt.charAt(j) - '0';
			}
		}
		
		int[][] map2 = new int[n][n];
		for(int i=0; i<arr2.length; i++) {
			String txt = secret(arr2[i], n);
			
			for(int j=0; j<txt.length(); j++) {
				map2[i][j] = txt.charAt(j) - '0';
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(map2[i][j]);
			}
			System.out.println();
		}
		
		int blankCk = 0;
		for(int i=0; i<n; i++) {
			answer[i] = "";
			
			for(int j=0; j<n; j++) {
				if(map1[i][j] == 1 || map2[i][j] == 1) {
					answer[i] = answer[i] + "#";
					blankCk = 0;
				} else if(blankCk == 0){
					answer[i] = answer[i] + " ";
					blankCk = 1;
				}
			}
		}

		System.out.println(Arrays.toString(answer));
	}

	static String secret(int n, int len) {
		String txt = "";
		
		while(n > 0) {
			txt = n % 2 + txt;
			n = n / 2;
		}
		
		for(int i=0; i<len-txt.length(); i++) {
			txt = "0" + txt;
		}
		
		return txt;
	}
}
