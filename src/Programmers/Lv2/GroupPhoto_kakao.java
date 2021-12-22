package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 단체사진 찍기
 * Date : 2021/12/22
 */
public class GroupPhoto_kakao {
	static private boolean[] visit = new boolean[8];
	static private int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String[] data = new String[n];
		
		for(int i=0; i<n; i++) {
			data[i] = bf.readLine();
		}
		
		////////////////////////////////////

		String[] member = {"A", "C", "F", "J", "M", "N", "R", "T"};
		photo(data, member, new StringBuilder());

		System.out.println(answer);
	}

	static private void photo(String[] data, String[] member, StringBuilder sb) {
		if(sb.length() > 7) {
			if (group(data, sb.toString())) answer++;
			return;
		}

		for(int i=0; i<8; i++) {
			if(!visit[i]) {
				sb.append(member[i]);
				visit[i] = true;
				photo(data, member, sb);
				visit[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	static private boolean group(String[] data, String member) {
		for(String t : data) {
			int member1 = member.indexOf(t.charAt(0));
			int member2 = member.indexOf(t.charAt(2));
			char hope = t.charAt(3);
			int distance = t.charAt(4) - '0';

			if(hope == '<') {
				if(Math.abs(member2 - member1)-1 >= distance) return false;
			} else if(hope == '>') {
				if(Math.abs(member2 - member1)-1 <= distance) return false;
			} else {
				if(Math.abs(member2 - member1)-1 != distance) return false;
			}
		}

		return true;
	}
}
