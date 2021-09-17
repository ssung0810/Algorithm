package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* IOIOI
 * Date : 2021/09/17
 */
public class BJoon5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int M = Integer.parseInt(bf.readLine());
        char[] S = bf.readLine().toCharArray();

        int cnt = 0;
        int answer = 0;
        for(int i=1; i<M-1; i++) {
            if(S[i-1] == 'I' && S[i] == 'O' && S[i+1] == 'I') {
                cnt++;
                i++;

                if(cnt == N) {
                    cnt--;
                    answer++;
                }
            } else {
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}
