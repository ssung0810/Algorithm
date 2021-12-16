package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/* 큰 수 만들기
 * Date : 2021/12/16
 */
public class MakeBigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String number = bf.readLine();
        int k = Integer.parseInt(bf.readLine());

        ///////////////////////////////////////////

        String answer = "";
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> saveNum = new ArrayList<>();

        char[] arr = number.toCharArray();
        Arrays.sort(arr);

        int len = number.length() - k;
        int bigNum = arr.length-1;

        while(len > 0) {
            int pos = number.indexOf(arr[bigNum]);

            if(pos == -1) {
                bigNum--;
            } else if(number.length() - pos >= len) {
                sb.append(arr[bigNum]);
                number = number.substring(pos+1);
                len--;

                int loop = 1;
                while(loop == 1) {
                    loop = 0;
                    for (int i = 0; i < saveNum.size(); i++) {
                        if (len <= 0) break;

                        char n = saveNum.get(i);
                        pos = number.indexOf(n);

                        if (pos == -1) {
                            saveNum.remove(i);
                        } else if (number.length() - pos >= len) {
                            sb.append(n);
                            number = number.substring(pos + 1);
                            len--;
                            saveNum.remove(i);
                            loop = 1;
                            break;
                        }
                    }
                }

                bigNum--;
            } else {
                saveNum.add(arr[bigNum]);
                bigNum--;
            }
        }

        System.out.println(sb.toString());
    }
}