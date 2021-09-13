package Programmers.WeeklyChange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 상호평가
 * Date : 2021/09/13
 */
public class week2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(bf.readLine());
        int[][] scores = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<N; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /////////////////////////////////

        String answer = "";
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<scores.length; i++) {
            int num = scores[i][i];
            int min = 100;
            int max = 0;
            int minCnt = 0;
            int maxCnt = 0;
            int sum = 0;
            int len = scores.length;

            for(int k=0; k<scores.length; k++) {
                int j = scores[k][i];

                if(min > j) {
                    min = j;
                    minCnt = 1;
                } else if(min == j) {
                    minCnt++;
                }

                if(max < j) {
                    max = j;
                    maxCnt = 1;
                } else if(max == j) {
                    maxCnt++;
                }

                sum += j;
            }

            if(min == num && minCnt == 1) {
                sum -= num;
                len--;
            } else if(max == num && maxCnt == 1) {
                sum -= num;
                len--;
            }

//            answer += score((double)sum / (double)len);
            sb.append(score((double)sum / (double)len));
        }

        System.out.println(answer);
    }

    static String score(double num) {
        if(num >= 90) return "A";
        else if(num >= 80) return "B";
        else if(num >= 70) return "C";
        else if(num >= 50) return "D";
        else return "F";
    }
}
