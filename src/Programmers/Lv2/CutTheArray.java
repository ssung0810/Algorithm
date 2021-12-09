package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* n^2 배열 자르기
 * Date : 2021/12/09
 */
public class CutTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long left = Long.parseLong(bf.readLine());
        long right = Long.parseLong(bf.readLine());

        /////////////////////////////////////////

        int len = (int) (right - left + 1);
        int[] answer = new int[len];
        int cnt = 0;

        while(left < right) {
            int x = (int)(left/n);
            int y = (int)(left%n);

            while(y < n && left <= right) {
                if(y <= x) {
                    answer[cnt] = x+1;
                } else {
                    answer[cnt] = y+1;
                }

                left++;
                cnt++;
                y++;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
