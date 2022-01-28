package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/* 양궁대회
 * Date : 2021/01/28
 */
public class ArcheryCompetition {
    static int[] score = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static int result = -1;
    static int[] ryan = new int[11];
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int[] info = new int[11];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<11; i++) {
            info[i] = Integer.parseInt(st.nextToken());
        }

        //////////////////////////////////////////////

        int[] answer = {};

        dfs(n, info, 0);

        if(result == -1) {
            System.out.println(result);
        } else {
//            Stack<Integer> s = new Stack<>();
//            int min = 100;
//
//            for(int i=10; i>=0; i--) {
//                for(int j=0; j<arr.size(); j++) {
//                    if(min > arr.get(j).get(i)) {
//                        s = new Stack<>();
//                        s.add(arr.get(j).get(i));
//                    } else if(min == arr.get(j).get(i)) {
//                        s.add(min);
//                    }
//                }
//            }

            for (ArrayList<Integer> list : arr) {
                System.out.println(list.toString());
            }
        }
    }

    static void dfs(int n, int[] info, int s) {
        if(s == 11 || n == 0) {
//            System.out.println(Arrays.toString(ryan));
            result(info);
            return;
        }

        for(int i=s; i<info.length; i++) {
            if(n > info[s]) {
                ryan[i] = info[i] + 1;
                dfs(n - info[i] - 1, info, i + 1);
            } else {
                ryan[i] = 0;
                dfs(n, info, i + 1);
            }

            ryan[i] = 0;
        }
    }

    static void result(int[] info) {
        int peachScore = 0;
        int ryanScore = 0;

        for(int i=0; i<11; i++) {
            if(info[i] != 0 || ryan[i] != 0) {
                if(info[i] < ryan[i]) {
                    ryanScore += score[i];
                } else {
                    peachScore += score[i];
                }
            }
        }

        if(ryanScore > peachScore) {
            if(ryanScore - peachScore > result) {
                result = ryanScore - peachScore;

                arr = new ArrayList<>();
                ArrayList<Integer> save = new ArrayList<>();
                for (int n : ryan) {
                    save.add(n);
                }
                arr.add(save);
            } else if(ryanScore - peachScore == result) {
                result = ryanScore - peachScore;
                ArrayList<Integer> save = new ArrayList<>();
                for (int n : ryan) {
                    save.add(n);
                }
                arr.add(save);
            }
        }
    }
}
