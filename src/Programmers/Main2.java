package Programmers;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main2 {
	public static void main(String[] args) throws IOException {
		String a = "BCA";
		char[] b = a.toCharArray();
		Arrays.sort(b);
		String c = new String(b);
		System.out.println(c);
	}
}
