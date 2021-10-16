package Programmers;

import java.io.IOException;

public class Main2 {

	public static void main(String[] args) throws IOException {
		int[] n = {5, -8, 4};

		int answer1 = Math.round(-n[1]+(int)(Math.sqrt(n[1]*n[1]-(4*n[0]*n[2]))))/2;
		int answer2 = Math.round(-n[1]-(int)(Math.sqrt(n[1]*n[1]-(4*n[0]*n[2]))))/2;

		if(n[1]*n[1]-(4*n[0]*n[2])==0) {
			System.out.printf("정답 : %d", answer1);
		}else if(n[1]*n[1]-(4*n[0]*n[2])<0){
			System.out.println("해가 없음");
		}else {
			System.out.printf("정답 : %d, %d", answer1, answer2);
		}
	}
}
