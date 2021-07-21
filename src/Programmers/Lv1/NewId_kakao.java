package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewId_kakao {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String new_id = bf.readLine();
		
		//////////////////////////////////////
		
		String answer = "";
		
		answer = textChange1(new_id);
		answer = textChange2(answer);
		
		// 최종문자열의 길이가 15개 이상일 경우
		if(answer.length() > 15) {
			if(answer.charAt(14) == '.') answer = answer.substring(0, 14);
			else answer = answer.substring(0, 15);
		}
		// new_id 가 공백이면 a입력
		else if(answer.equals("")) {
			answer = "aaa";
        }
		// new_id 가 3자 이하이면 최소 3자로 맞추기
		else if(answer.length() < 3) {
            char txt = answer.charAt(answer.length()-1);
            while(answer.length() < 3) {
            	answer += txt;
            }
        }
        
        System.out.println(answer);
        
	}

	// 필요없는 특수문자 제외, 대문자 소문자로 변환
	static String textChange1(String new_id) {
		String answer = "";
		
		for(int i=0; i<new_id.length(); i++) {
			// 대문자면 소문자로 변환
			if((int)new_id.charAt(i) >= 65 && (int)new_id.charAt(i) <= 90) {
				answer += (char)(new_id.charAt(i)+32);
			}
			// 필요없는 특수문자 제외
			else if( (((int)new_id.charAt(i) >= 48 && (int)new_id.charAt(i) <= 57) || ((int)new_id.charAt(i) >= 97
					&& (int)new_id.charAt(i) <= 122) || new_id.charAt(i) == '.' || new_id.charAt(i) == '-' || new_id.charAt(i) == '_') == false) {
				
			}
			else {
				answer += new_id.charAt(i);
			}
		}
		
		return answer;
	}
	
	// .이 2개이상 연속되어있으면 1개로 변환, 맨앞 맨뒤가 .이면 삭제
	static String textChange2(String new_id) {
		String answer = "";
		
		for(int i=0; i<new_id.length(); i++) {
			// .이 2개이상이면 1개로 만들기
			if(new_id.charAt(i) == '.') {
				answer += new_id.charAt(i);
				int cnt = i+1;
				while(cnt < new_id.length() && new_id.charAt(cnt) == '.') {
					cnt++;
				}
				i = cnt - 1;
			}
			else {
				answer += new_id.charAt(i);
			}
		}
		
		if(answer.length() > 0 && answer.charAt(0) == '.') answer = answer.substring(1, answer.length());
		if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
		
		return answer;
	}
}
