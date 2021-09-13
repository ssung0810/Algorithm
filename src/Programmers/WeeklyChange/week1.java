package Programmers.WeeklyChange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 부족한 금액 계산하기
 * Date : 2021/09/13
 */
public class week1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int price = Integer.parseInt(bf.readLine());
        int money = Integer.parseInt(bf.readLine());
        int count = Integer.parseInt(bf.readLine());

        ////////////////////////////////////

        long answer = 0;

        while(count > 0) {
            answer += count*price;

            count--;
        }

        System.out.println(answer > money ? answer-money : 0);
    }
}
