package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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
        String[] arr = new String[numbers.length];
        HashMap<String, String> map = new HashMap<>();

        for(int i=0; i<numbers.length; i++) {
            String txt = String.valueOf(numbers[i]);
            arr[i] = txt+txt+txt;
            map.put(arr[i], txt);
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i=0; i<numbers.length; i++) {
            arr[i] = map.get(arr[i]);
            answer += arr[i];
        }

        if(answer.charAt(0) == '0') answer = "0";

        System.out.println(answer);
    }

}
