package Programmers;

import java.io.IOException;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		HashSet<Integer> set = new HashSet<>();
		HashSet<Integer> set2 = new HashSet<>();

		set.add(1);
		set.add(3);
		set.add(2);

		set2.add(1);
		set2.add(3);
		set2.add(4);


		System.out.println(set.containsAll(set2));
	}
}