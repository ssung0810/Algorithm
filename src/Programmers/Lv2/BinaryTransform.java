package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 이진 변환
 * Date : 2021/12/21
 */
public class BinaryTransform {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        /////////////////////////////////////////////////

        int[] answer = new int[2];

        while (!s.equals("1")) {
            int n = s.replaceAll("0", "").length();
            answer[1] += s.length()-n;

            s = Integer.toBinaryString(n);
            answer[0]++;
        }

        System.out.println(Arrays.toString(answer));
    }
}
