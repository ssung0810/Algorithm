package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 괄호 변환
 * Date : 2021/12/23
 */
public class ParenthesisChange {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String p = bf.readLine();

        ////////////////////////////////////////

        String answer = "";

        answer = CorrectString(p);

        System.out.println(answer);
    }

    static String CorrectString(String p) {
        if(isCorrect(p)) return p;

        int idx = split(p);
        String u = p.substring(0, idx);
        String v = p.substring(idx);

        if (isCorrect(u)) {
            p = u + CorrectString(v);
        } else {
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(")");
                else sb.append("(");
            }
            v = v.equals("") ? v : CorrectString(v);
            p = "(" + v + ")" + sb.toString();
        }

        return p;
    }

    static int split(String p) {
        int cnt = 1;
        int idx = 1;
        char t = p.charAt(0);

        while(cnt > 0) {
            if(p.charAt(idx) != t) cnt--;
            else cnt++;
            idx++;
        }

        return idx;
    }

    static private boolean isCorrect(String t) {
        if(t.charAt(0) == ')') return false;

        int check = 1;

        for(int i=1; i<t.length(); i++) {
            if(t.charAt(i) == '(') check++;
            else check--;

            if(check < 0) return false;
        }

        return true;
    }
}
