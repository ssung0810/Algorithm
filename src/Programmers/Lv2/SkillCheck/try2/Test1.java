package Programmers.Lv2.SkillCheck.try2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
    static String[] numList = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int t = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());
        int p = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////////

        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        sb.append("0");

        int cnt = 1;
        while(sb.length() < t*m) {
            if(n == 10) {
                sb.append(cnt);
            } else {
                sb.append(getChange(n, cnt));
            }

            cnt++;
        }

        int idx = p-1;
        for(int i=0; i<t; i++,idx+=m) {
            answer.append(sb.charAt(idx));
        }

        System.out.println(answer.toString());
    }

    static String getChange(int n, int num) {
        StringBuilder sb = new StringBuilder();

        while(num > 0) {
            sb.insert(0, numList[num % n]);
            num /= n;
        }

        return sb.toString();
    }
}
