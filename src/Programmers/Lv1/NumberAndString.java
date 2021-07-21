package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberAndString {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String s = bf.readLine();
		
		///////////////////////////////////
		
		String result = "";
		
		for(int i=0; i<s.length(); i++) {
			if((int)s.charAt(i) < 48 || (int)s.charAt(i) > 57) {
				switch(s.charAt(i)) {
					case 'z': 
						result += '0';
						i += 3;
					break;
					case 'o': 
						result += '1';
						i += 2;
					break;
					case 't': 
						if(s.charAt(i+1) == 'w') {
							result += '2';
							i += 2;
						} else {
							result += '3';
							i += 4;
						}
					break;
					case 'f': 
						if(s.charAt(i+1) == 'o') {
							result += '4';
							i += 3;
						} else {
							result += '5';
							i += 3;
						}
					break;
					case 's': 
						if(s.charAt(i+1) == 'i') {
							result += '6';
							i += 2;
						} else {
							result += '7';
							i += 4;
						}
					break;
					case 'e': 
						result += '8';
						i += 4;
					break;
					case 'n': 
						result += '9';
						i += 3;
					break;
				}
			} else {
				result += s.charAt(i);
			}
		}
		
		System.out.println(result);
	}

}
