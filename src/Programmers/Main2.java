package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main2 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		HashMap<String, String> m = new HashMap<>();
		m.put("a", "abc");
//		m.put("b", "ab");
		
		String a = "bac";
		
		for(int i=1; i<=a.length(); i++) {
			System.out.println(a.substring(0, i));
		}
		
	}

}
