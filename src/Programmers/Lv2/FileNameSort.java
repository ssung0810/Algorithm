package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/* 파일명 정렬
 * Date : 2021/10/06
 */
public class FileNameSort {
    static String[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] files = new String[N];

        for(int i=0; i<N; i++) {
            files[i] = bf.readLine();
        }

        /////////////////////////////////

        arr = new String[files.length][3];
        String[] answer = new String[files.length];

        for(int i=0; i<files.length; i++) {
            int idx = strSplit(files[i]);
            arr[i][0] = files[i].substring(0, idx);
            int idx2 = intSplit(files[i], idx);
            arr[i][1] = files[i].substring(idx, idx2);
            arr[i][2] = files[i].substring(idx2);
        }

        Arrays.sort(arr, comp);

        for(int i=0; i<files.length; i++) {
            answer[i] = arr[i][0] + arr[i][1] + arr[i][2];
        }

        System.out.println(Arrays.toString(answer));
    }

    static Comparator<String[]> comp = new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            String a = o1[0].toUpperCase();
            String b = o2[0].toUpperCase();

            if(a.equals(b)) {
                return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
            }

            return a.compareTo(b);
        }
    };

    static int strSplit(String txt) {
        int index = 0;

        for(int i=0; i<txt.length(); i++) {
            if(txt.charAt(i) >= 48 && txt.charAt(i) <= 57) {
                index = i;
                break;
            }
        }

        return index;
    }

    static int intSplit(String txt, int idx) {
        int index = txt.length();

        for(int i=idx; i<txt.length(); i++) {
            if(txt.charAt(i) < 48 || txt.charAt(i) > 57) {
                index = i;
                break;
            }
        }

        return index;
    }
}
