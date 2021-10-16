package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 수식 최대화
 * Date : 2021/10/15
 */
public class MaxValue {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String expression = bf.readLine();

        //////////////////////////////////////

        long answer = 0;

        int[] exp = new int[3];     // +, -, *

        if(expression.contains("+")) exp[0] = 1;
        if(expression.contains("-")) exp[1] = 2;
        if(expression.contains("*")) exp[2] = 3;

        String[] number = new String[3];
        String[] number_exp = new String[3];
        for(int i=0; i<3; i++) {
            String num = "";
            for(int j=0; j<expression.length(); j++) {
                num += expression.charAt(j);
                if(j+1 < expression.length() && expression.charAt(j) == '+') {

                }
            }
        }
    }

}
