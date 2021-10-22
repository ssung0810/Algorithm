package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 괄호 제거
 * Date : 2021/10/20
 */
public class BJoon2800 {
    static ArrayList<Pair> arr = new ArrayList<>();
    static ArrayList<String> answer = new ArrayList<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        String s = bf.readLine();
        char[] s_arr = s.toCharArray();

        for(int i=0; i<s_arr.length; i++) {
            if(s_arr[i] == '(') {
                st.push(i);
            } else if(s_arr[i] == ')') {
                arr.add(new Pair(st.pop(), i));
            }
        }

        dfs(s_arr, arr.size(), 0);

        for(String str : set) {
            answer.add(str);
        }
        Collections.sort(answer);

        for(String str : answer) {
            sb.append(str + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(char[] s_arr, int cnt, int d) {
        if(d > cnt) return;

        for(int c=d; c<cnt; c++) {
            Pair p = arr.get(c);

            s_arr[p.left] = ' ';
            s_arr[p.right] = ' ';

            String str = new String(s_arr);
            str = str.replaceAll(" ", "");

            set.add(str);

            dfs(s_arr, cnt, c+1);

            s_arr[p.left] = '(';
            s_arr[p.right] = ')';
        }
    }
}

class Pair {
    int left;
    int right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}
