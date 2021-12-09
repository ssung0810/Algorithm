package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* n 진수 게임
 * Date : 2021/12/09
 */
public class nGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int t = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int p = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////////

        StringBuilder sb = new StringBuilder();
        StringBuilder txt = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        txt.append("0");

        for(int i=1; i<m*t; i++) {
            sb = new StringBuilder();
            int num = i;
            while(num >= n) {
//                System.out.println(numberCheck(num%n));
                sb.insert(0, numberCheck(num%n));
                num /= n;
            }

            if(num != 0) sb.insert(0, numberCheck(num));

            txt.append(sb.toString());
        }

//        System.out.println(txt.toString());

        for(int i=0, s=p-1; i<t; i++, s+=m) {
            answer.append(txt.charAt(s));
        }

        System.out.println(answer.toString());
    }

    static String numberCheck(int num) {
        String s = String.valueOf(num);

        if(num >= 10) {
            switch (num) {
                case 10: s="A"; break;
                case 11: s="B"; break;
                case 12: s="C"; break;
                case 13: s="D"; break;
                case 14: s="E"; break;
                case 15: s="F"; break;
            }
        }

        return s;
    }
}
