package Programmers.test.v2;

import java.util.Arrays;

/* 비밀지도
 * Date : 2022/03/28
 */
public class test1 {

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        String[] answer = solution(n, arr1, arr2);

        System.out.println(Arrays.toString(answer));
    }

    private static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = getMap(binary(arr1[i], n), binary(arr2[i], n));
        }

        return answer;
    }

    static char[] binary(int arr, int n) {
        StringBuilder sb = new StringBuilder();

        for (int i = n-1; i >= 0; i--) {
            if(arr == 0) sb.insert(0, 0);
            else {
                sb.insert(0, arr % 2);
                arr = arr / 2;
            }
        }

        return sb.toString().toCharArray();
    }

    static String getMap(char[] char1, char[] char2) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < char1.length; i++) {
            if(char1[i] == '1' || char2[i] == '1') sb.append("#");
            else sb.append(" ");
        }

        return sb.toString();
    }
}
