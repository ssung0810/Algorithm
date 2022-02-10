package Programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();

		sb.append("01234");

		sb.delete(2, 3);

		System.out.println(sb.toString());
	}
}