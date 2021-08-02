package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 오픈채팅방
 * Date : 2021/08/02
 */
public class OpenChat_kakao {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(bf.readLine());
		String[] record = new String[N];
		
		StringTokenizer st = new StringTokenizer(bf.readLine(), ",");
		for(int i=0; i<N; i++) {
			record[i] = st.nextToken();
		}
		
		///////////////////////////////
		
		String[] answer = {};
		
		HashMap<String, String> m = new HashMap<>();
		int len = 0;
		
		for(int i=0; i<record.length; i++) {
			if(!record[i].split(" ")[0].equals("Leave")) {
				m.put(record[i].split(" ")[1], record[i].split(" ")[2]);
			}
			
			if(!record[i].split(" ")[0].equals("Change")) len++;
		}
		
		answer = new String[len];
		
		for(int i=0, cnt=0; i<record.length; i++) {
			switch(record[i].split(" ")[0]) {
				case "Enter":
					answer[cnt] = m.get(record[i].split(" ")[1]) + "님이 들어왔습니다.";
					cnt++;
				break;
				
				case "Leave":
					answer[cnt] = m.get(record[i].split(" ")[1]) + "님이 나갔습니다.";
					cnt++;
				break;
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}

}
