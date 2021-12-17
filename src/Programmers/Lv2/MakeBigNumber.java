package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 큰 수 만들기
 * Date : 2021/12/17
 */
public class MakeBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();
        int k = Integer.parseInt(bf.readLine());

        ///////////////////////////////////////////

        String answer = "";
        StringBuilder sb = new StringBuilder();
        int max = 0;

        for(int i=1; i<=number.length()-k; i++) {
            for(int j=max+1; j<k+i; j++) {
                if(number.charAt(max) < number.charAt(j)) {
                    max = j;
                }
            }

            sb.append(number.charAt(max));
            max++;
        }

        System.out.println(sb.toString());
    }
}