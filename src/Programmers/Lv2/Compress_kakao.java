package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* [3차]압축
 * Date : 2022/01/25
 */
public class Compress_kakao {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String msg = bf.readLine();

        //////////////////////////////////////////////

        int[] answer = {};

        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();

        int flag = 0;
        for (int i = 1; i <= 26; i++) {
            char alpha = (char) (i + 64);
            map.put(String.valueOf(alpha), i);
            flag = i;
        }

        for (int i = 0; i < msg.length(); i++) {
            int cnt = i+2;

            for(int j=cnt; j<=msg.length(); j++, cnt++) {
                if(!map.containsKey(msg.substring(i, cnt))) break;
            }

            if(cnt <= msg.length()) {
                arr.add(map.get(msg.substring(i, cnt - 1)));
                map.put(msg.substring(i, cnt), ++flag);
            } else {
                arr.add(map.get(msg.substring(i)));
            }

            i = cnt - 2;
        }

        answer = new int[arr.size()];
        for (int i=0; i<arr.size(); i++) {
            answer[i] = arr.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }
}