package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 위장
 * Date : 2021/11/06
 */
public class Camouflage {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());
        String[][] clothes = new String[n][2];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(bf.readLine());
            clothes[i][0] = st.nextToken();
            clothes[i][1] = st.nextToken();
        }

        /////////////////////////////////////////////////////

        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        for(String key : map.keySet()) {
            answer *= map.get(key)+1;
        }

        System.out.println(answer-1);
    }
}
