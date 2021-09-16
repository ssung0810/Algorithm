package Programmers.WeeklyChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/* 직업군 추천하기
 * Date : 2021/09/15
 */
public class week4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        String[] table = new String[N];

        for(int i=0; i<N; i++) {
            table[i] = bf.readLine();
        }

        int M = Integer.parseInt(bf.readLine());
        String[] languages = new String[M];
        int[] preference = new int[M];

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++) {
            languages[i] = st.nextToken();
        }

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++) {
            preference[i] = Integer.parseInt(st.nextToken());
        }

        /////////////////////////////////////////

        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<languages.length; i++) {
            map.put(languages[i], preference[i]);
        }

        String[] company = new String[6];
        int max = 0;
        int sum = 0;

        for(int i=0; i<table.length; i++) {
            sum = 0;
            company = table[i].split(" ");



            for(int j=1, n=5; j<company.length; j++, n--) {
                if(map.containsKey(company[j])) {
                    sum += map.get(company[j]) * n;
                }
            }

            if(max < sum) {
                max = sum;
                answer = company[0];
            } else if(max == sum) {
                if(answer.compareTo(company[0]) > 0) answer = company[0];
            }
        }

        System.out.println(answer);
    }
}
