package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/* 가장 큰 수
 * Date : 2021/08/12
 */
public class BigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] numbers = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        ///////////////////////////////////

        String answer = "";
        String[] arr = new String[N];
        for(int i=0; i<N; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        /*Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1 - o2 > 0) {
                    return 1;
                }
                return 0;
            }
        });*/

        for(int i=0; i<N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

//    public static Comparator<arr> comp = new Comparator<arr>() {
//        @Override
//        public int compare(arr o1, arr o2) {
//            return 0;
//        }
//    }
}
