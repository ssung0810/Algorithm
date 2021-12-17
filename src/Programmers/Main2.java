package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String number = bf.readLine();
		int k = Integer.parseInt(bf.readLine());

		///////////////////////////////////////////

		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i=0; i<number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);

			System.out.println(k);
		}
		for (int i=0; i<result.length; i++) {
			result[i] = stack.get(i);
		}

		System.out.println(new String(result));
	}
}