package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* n^2 배열 자르기
 * Date : 2021/11/26
 */
public class CutTheArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long left = Long.parseLong(bf.readLine());
        long right = Long.parseLong(bf.readLine());

        /////////////////////////////////////////

        int len = (int)(right-left+1);
        int[] answer = new int[len];

        int row = (int) left / n;
        int col = (int) left % n;
        int cnt = 0;
        int endRow = (int) right / n;
        int endCol = (int) right % n;

//        System.out.println(row + " :: " + col + " :: " + endRow + " :: " + endCol);
        while(true) {
//            System.out.println(row + " :: " + col + " :: " + endRow + " :: " + endCol);
            if(row >= col) answer[cnt] = row+1;
            else answer[cnt] = col+1;

            cnt++;
            col++;

            if(row == endRow) {
                if(col > endCol) break;
            }

            if(col == n) {
                row++;
                col = 0;
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
