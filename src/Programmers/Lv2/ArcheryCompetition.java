package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 양궁대회
 * Date : 2021/01/28
 */
public class ArcheryCompetition {
    static int[] score = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int result = 1;
    static int[] ryan = new int[11];
    static int[] answer = new int[11];
    static int flag = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] info = new int[11];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 11; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        //////////////////////////////////////////////

        dfs(n, info, 0);

        if (flag == -1) System.out.println(result);
        else System.out.println(Arrays.toString(answer));
    }

    // 깊이 우선 탐색으로 전체 경우의 수 살펴보기
    static void dfs(int n, int[] info, int s) {
        if (s == 11 || n == 0) {
            if (n != 0) ryan[10] = n;
            result(info);
            return;
        }

        for (int i = s; i < info.length; i++) {
            if (n > info[i]) {
                ryan[i] = info[i] + 1;
                dfs(n - info[i] - 1, info, i + 1);
            } else {
                ryan[i] = 0;
                dfs(n, info, i + 1);
            }

            ryan[i] = 0;
        }
    }

    // for문이 처음부터 끝까지 돌았을 때 어피치와 라이언의 점수 비교하기
    static void result(int[] info) {
        int peachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < 11; i++) {
            if (info[i] != 0 || ryan[i] != 0) {
                if (info[i] < ryan[i]) {
                    ryanScore += score[i];
                } else {
                    peachScore += score[i];
                }
            }
        }

        if (ryanScore - peachScore >= result) {
            flag = 1;

            if(ryanScore - peachScore > result) answer = ryan.clone();
            else {
                if (!Arrays.equals(answer, ryan)) {
                    answer = getArray(answer, ryan, info);
                }
            }

            result = ryanScore - peachScore;
        }
    }

    static int[] getArray(int[] answer, int[] ryan, int[] info) {
        for(int i=10; i>=0; i--) {
            if(ryan[i] > answer[i]) return ryan.clone();
            else if(ryan[i] < answer[i]) return answer;
        }

        return answer;
    }
}
