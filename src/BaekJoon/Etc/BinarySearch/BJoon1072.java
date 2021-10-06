package BaekJoon.Etc.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 게임
 * Date : 2021/09/28
 */
public class BJoon1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int answer = -1;
        int num = (int)(Y/X*100);
        int cnt = 0;

        if(X != Y && num != 99) {
            while (true) {
                X += 1;
                Y += 1;
                cnt++;

                if (num != (int) ((double)Y / (X * 100))) {
                    answer = cnt;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
