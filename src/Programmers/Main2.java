package Programmers;

public class Main2 {

	public static void main(String[] args) {
		String txt = "";
		int n = 1;
		int len = 5;
		
		while(n > 0) {
			txt = n % 2 + txt;
			n = n / 2;
		}
		
		len = len - txt.length();
		for(int i=0; i<len; i++) {
			txt = "0" + txt;
		}
		
		System.out.println(txt);
	}

}
