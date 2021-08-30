package BaekJoon.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 이친수
 * Date : 2021/08/30
 */
public class BJoon2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        long a=1, b=1, sum=1;

        for(int i=1; i<N-1; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        System.out.println(sum);
    }
}
