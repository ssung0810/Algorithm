package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 예상 대진표
 * Date : 2021/08/17
 */
public class MatchTable {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int a = Integer.parseInt(bf.readLine());
        int b = Integer.parseInt(bf.readLine());

        ////////////////////////////////////////////

        int answer = 0;

        while(a != b) {
            answer++;
            if(a%2==1) a+=1;
            if(b%2==1) b+=1;
            a/=2;
            b/=2;
        }

        System.out.println(answer);
    }
}
