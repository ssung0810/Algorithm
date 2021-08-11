package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 전화번호 목록
 * Date : 2021/08/11
 */
public class PhoneNumberList {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(bf.readLine());
		String[] phone_book = new String[N];
		st = new StringTokenizer(bf.readLine());
		for(int i=0; i<N; i++) {
			phone_book[i] = st.nextToken();
		}
		
		///////////////////////////////////////
		
		boolean answer = true;
        
        HashMap<String, Integer> m = new HashMap<>();
        for(int i=0; i<phone_book.length; i++) {
            m.put(phone_book[i], i);
        }
        
        for(int i=0; i<phone_book.length; i++) {
            String txt = phone_book[i];
            
            for(int j=1; j<txt.length(); j++) {
                if(m.containsKey(txt.substring(0,j))) {
                    answer = false;
                }
            }
        }
        
        
        System.out.println(answer);
	}

}
