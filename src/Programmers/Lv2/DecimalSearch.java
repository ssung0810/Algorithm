package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DecimalSearch {
    static boolean[] visit;
    static boolean[] dp = new boolean[9999999];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String numbers = bf.readLine();

        /////////////////////////////////

        char[] numList = numbers.toCharArray();
        visit = new boolean[numList.length];

        make(numList, 0, "");

        System.out.println(answer);
    }

    static void make(char[] numList, int D, String txt) {
        if(numList.length == D) {
            return;
        }

        for(int i=0; i<numList.length; i++) {
            int num = Integer.parseInt(txt + numList[i]);

            if(!visit[i]) {
                if(dp[num] == false) if(decimal(num)) answer++;
                dp[num] = true;
                visit[i] = true;
                make(numList, D+1, txt+numList[i]);
                visit[i] = false;
            }
        }
    }

    static boolean decimal(int num) {
        if(num < 2) return false;

        for(int i=2; i*i<=num; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }
}
