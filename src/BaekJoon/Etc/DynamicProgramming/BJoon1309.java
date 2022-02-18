package BaekJoon.Etc.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 동물원
 * Date : 2022/02/11
 */
public class BJoon1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////////

        int[][] cage = new int[N][2];
        cage[0][0] = 1;

        int answer = 0;

        for(int i=1; i<cage.length; i++) {
            cage[i][0] = (cage[i - 1][0] + 1 + cage[i - 1][1]) % 9901;
            cage[i][1] = cage[i - 1][0] * 2 + cage[i - 1][1];
        }

        for(int i=0; i< cage.length; i++) {
            answer += cage[i][0];
        }

        answer = answer * 2 + 1;

        System.out.println(answer%9901);
    }
}
