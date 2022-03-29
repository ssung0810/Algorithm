package Programmers.test.v1;

import java.util.LinkedList;
import java.util.Queue;

/* 캐시
 * Date : 2022/03/28
 */
public class test2 {

    public static void main(String[] args) {
        int cacheSize = 1;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};

        int answer = solution(cacheSize, cities);

        System.out.println(answer);
    }

    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0) {
            return cities.length * 5;
        }

        Queue<String> q = new LinkedList<>();
        for (String city : cities) {
            city = city.toLowerCase();

            if(q.contains(city)) {
                answer++;
                q.remove(city);
                q.add(city);
            } else {
                answer += 5;

                if (q.size() == cacheSize) {
                    q.poll();
                    q.add(city);
                } else {
                    q.add(city);
                }
            }
        }

        return answer;
    }
}
