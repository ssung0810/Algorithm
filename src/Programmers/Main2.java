package Programmers;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		ArrayList<Character> a = new ArrayList<>();

		a.add('8');
		a.add('6');
		a.add('4');

		for(int i=0; i<a.size(); i++) {
			char n = a.get(i);
			if(n == '8' || n == '4') {
				a.remove(i);
			}
		}

		for(char n : a) {
			System.out.println(n);
		}

		System.out.println(a.get(0));
	}
}