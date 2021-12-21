package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 단체사진 찍기
 * Date : 2021/08/06
 */
public class GroupPhoto_kakao {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		String[] data = new String[n];
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for(int i=0; i<n; i++) {
			data[i] = st.nextToken();
		}
		
		////////////////////////////////////


	}


}
