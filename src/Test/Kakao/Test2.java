package Test.Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int k = Integer.parseInt(bf.readLine());

        ///////////////////////////////////////

        int answer = 0;
        String txt = "";
        String c = "";
        if(k == 10) {
            c = String.valueOf(n);
        } else {
            c = change(n, k);
        }

        for(int i=0; i<c.length(); i++) {
            if(c.charAt(i) != '0') {
                txt += c.charAt(i);

                if(i == c.length()-1) {
                    if(prime(Integer.parseInt(txt))) {
                        answer++;
                    }
                }
            } else if(c.charAt(i) == '0' && !txt.equals("")) {
                if(prime(Long.parseLong(txt))) {
                    answer++;
                }
                txt = "";
            }
        }

        System.out.println(answer);
    }

    static String change(int n, int k) {
        String c = "";

        while(n != 0) {
            c = (n % k) + c;
            n /= 3;
        }

        return c;
    }

    static boolean prime(long N) {
        if(N == 1) return false;

        for(long i=2; i*i<=N; i++) {
            if(N % i == 0) {
                return false;
            }
        }

        return true;
    }
}
