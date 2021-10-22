package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJoon16916 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String S = bf.readLine();
        String P = bf.readLine();

        int[] pi = new int[P.length()];

        getPi(pi, P);
        System.out.println( KMP(S, P, pi) == true ? 1 : 0 );
    }

    static void getPi(int[] pi, String P) {
        int j=0;
        for(int i=1; i<pi.length; i++) {
            while(j > 0 && P.charAt(j) != P.charAt(i)) {
                j = pi[j-1];
            }

            if(P.charAt(j) == P.charAt(i)) {
                pi[i] = ++j;
            }
        }
    }

    static boolean KMP(String S, String P, int[] pi) {
        int j=0;
        for(int i=0; i<S.length(); i++) {
            while(j>0 && P.charAt(j) != S.charAt(i)) {
                j = pi[j-1];
            }

            if(P.charAt(j) == S.charAt(i)) {
                if(j == P.length()-1) {
                    return true;
                } else {
                    j++;
                }
            }
        }

        return false;
    }
}
