package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* k진수에서 소수 개수 구하기
 * Date : 2022/02/03
 */
public class GetPrimeNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int k = Integer.parseInt(bf.readLine());

        //////////////////////////////////////////////

        int answer = 0;
        String changeNum = getChange(n, k);
        StringBuilder sb = new StringBuilder();

        System.out.println(changeNum);

        for(int i=0; i<changeNum.length(); i++) {
            char c = changeNum.charAt(i);

            if(c == '0') {
                if(sb.length() > 0 && getPrime(sb.toString())) {
                    answer++;
                }
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }

        if(sb.length() > 0 && getPrime(sb.toString())) answer++;

        System.out.println(answer);
    }

    static String getChange(int n, int k) {
        if(k == 10) return String.valueOf(n);

        StringBuffer sb = new StringBuffer();
        while(n != 0) {
            sb.insert(0, n%k);
            n /= k;
        }

        return sb.toString();
    }

    static boolean getPrime(String num) {
        long n = Long.parseLong(num);

        if(n == 1) return false;
        if(n == 2) return true;

        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
