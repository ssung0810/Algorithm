package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.StringTokenizer;

/* 캐시
 * Date : 2021/11/09
 */
public class Cache_kakao {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int cacheSize = Integer.parseInt(bf.readLine());
        int n = Integer.parseInt(bf.readLine());
        String[] cities = new String[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            cities[i] = st.nextToken();
        }

        /////////////////////////////////////////////////////

        int answer = 0;
        Queue<String> q = new LinkedList<>();

        if(cacheSize == 0) {
            answer = cities.length*5;
            System.out.println(answer);
            System.exit(0);
        }

        for(String city : cities) {
            city = city.toUpperCase();

            if(q.contains(city)) {
                q.remove(city);
                answer++;
            }
            else {
                if(q.size() >= cacheSize) q.poll();
                answer += 5;
            }

            q.add(city);
        }

        System.out.println(answer);
    }
}
