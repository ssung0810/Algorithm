package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 조이스틱
 * Date : 2021/12/02
 */
public class JoyStick {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String name = bf.readLine();
		
		///////////////////////////

		int answer = 0;
		int[] move = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		boolean[] visit = new boolean[name.length()];
		visit[0] = true;

		for(int i=0; i<name.length(); i++) {
			int num = move[name.charAt(i)-'A'];
			answer += num;
			if(num == 0) visit[i] = true;
		}

		int left = 0;
		int right = 0;
		int cnt = 0;
		while (cnt < name.length()) {
			if(left == 0) left = visit.length-1;
			else left--;

			if(right == visit.length-1) right=0;
			else right++;

			cnt++;

			if(visit[right] == false) {
				visit[right] = true;
				left = right;
				answer += cnt;
				cnt = 0;
			} else if(visit[left] == false) {
				visit[left] = true;
				right = left;
				answer += cnt;
				cnt = 0;
			}
		}

		System.out.println(answer);
	}
}
