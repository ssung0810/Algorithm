package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 구명보트
 * Date : 2021/11/16
 */
public class LifeBoat {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] people = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        int limit = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////

        int answer = 0;
        Arrays.sort(people);

        int sum = 0;
        for(int i=0; i<people.length; i++) {
            if(sum + people[i] > limit) {
                answer++;
                sum = 0;
            }

            sum += people[i];
        }

        answer = sum == 0 ? answer : answer + 1;

        System.out.println(answer);
    }
}
