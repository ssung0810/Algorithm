package Programmers;

import java.io.IOException;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws IOException {
		ArrayList<test> a = new ArrayList();

		a.add(new test(2));
		a.add(new test(1));
		a.add(new test(3));

		Collections.sort(a, comp);

		for(test b : a) {
			System.out.println(b.num);
		}
	}

	static Comparator<test> comp = new Comparator<test>() {
		@Override
		public int compare(test o1, test o2) {
			if(o1.num > o2.num) return 1;
			return -1;
		}
	};
}

class test {
	int num;

	public test(int num) {
		this.num = num;
	}
}