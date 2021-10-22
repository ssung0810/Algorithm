package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/* 단어 섞기
 * Date : 2021/10/21
 */
public class BJoon9177 {
    static String result;
    static char[] a,b,c;
    static boolean answer;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        String txt = "Data set ";
        Set<Character> set = new HashSet<>();

        main :
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(bf.readLine());
            a = st.nextToken().toCharArray();
            b = st.nextToken().toCharArray();
            c = st.nextToken().toCharArray();
            answer = false;
            result = "no";

            int len_a = a.length;
            int len_b = b.length;
            for(int j=0; j<Math.max(len_a, len_b); j++) {
                if(j<len_a) set.add(a[j]);
                if(j<len_b) set.add(b[j]);
            }

            for(int j=0; j<c.length; j++) {
                if(set.add(c[j])) {
                    sb.append(txt + i + ": no" + "\n");
                    set.clear();
                    continue main;
                }
            }

            findWord(0, 0, 0);
            result = answer == true ? "yes" : "no";
            sb.append(txt + i + ": " + result + "\n");
            set.clear();
        }

        System.out.println(sb);
    }

    static void findWord(int idx1, int idx2, int cnt) {
        if(answer) return;

        if(idx1 + idx2 == c.length) {
            answer = true;
            return;
        }

        if(idx1 < a.length && a[idx1] == c[cnt])
            findWord(idx1+1, idx2, cnt+1);
        if(idx2 < b.length && b[idx2] == c[cnt])
            findWord(idx1, idx2+1, cnt+1);
    }
}
