package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 2 x n 타일링
 * Date : 2021/08/30
 */
public class BJoon11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int a = 1, b = 2, sum = 0;

        for(int i=1; i<N-1; i++) {
            sum = (a + b) % 10007;
            a = b;
            b = sum;
        }

        System.out.println(sum);
    }
}
