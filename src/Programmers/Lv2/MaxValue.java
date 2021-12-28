package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/* 수식 최대화
 * Date : 2021/12/28
 */
public class MaxValue {
    static boolean[] visit = new boolean[3];
    static ArrayList<Long> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String expression = bf.readLine();

        //////////////////////////////////////

        long answer = 0;

        ArrayList<Long> number = new ArrayList<>();
        ArrayList<Character> sign = new ArrayList<>();

        int cnt = 0;
        for(int i=0; i<expression.length(); i++) {
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                number.add(Long.parseLong(expression.substring(cnt, i)));
                sign.add(expression.charAt(i));
                cnt = i+1;
            }
        }
        number.add(Long.parseLong(expression.substring(cnt)));

        ArrayList<char[]> sign_arr = new ArrayList<>();
        sign_arr.add(new char[]{'+', '-', '*'});
        sign_arr.add(new char[]{'+', '*', '-'});
        sign_arr.add(new char[]{'*', '+', '-'});
        sign_arr.add(new char[]{'*', '-', '+'});
        sign_arr.add(new char[]{'-', '+', '*'});
        sign_arr.add(new char[]{'-', '*', '+'});

        for(char[] c : sign_arr) {
            answer = Math.max(answer, plus(new ArrayList<>(number), new ArrayList<>(sign), c));
        }

//        System.out.println(a + " :: " + b + " :: " + c);

        System.out.println(answer);
    }

    static long plus(ArrayList<Long> number, ArrayList<Character> sign_arr, char[] sign) {
        for(int j=0; j<3; j++) {
            for (int i = 0; i < sign_arr.size(); i++) {
                if (sign_arr.get(i) == sign[j]) {
                    long num1 = number.get(i);
                    long num2 = number.get(i+1);
                    number.remove(i+1);
                    number.remove(i);
                    sign_arr.remove(i);
                    number.add(i, calc(num1, sign[j], num2));

                    i--;
                }
            }
        }

        return Math.abs(number.get(0));
    }

    static long calc(long num1, char sign, long num2) {
        if(sign == '-') return (num1-num2);
        else if(sign == '+') return (num1+num2);
        else if(sign == '*') return (num1*num2);

        return '0';
    }
}
