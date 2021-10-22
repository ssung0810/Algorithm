package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* AC
 * Date : 2021/10/18
 */
public class BJoon5430 {
    static StringBuilder sb = new StringBuilder();;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(bf.readLine());

        while(T-- > 0) {
            String p = bf.readLine();
            int n = Integer.parseInt(bf.readLine());
            String str = bf.readLine();
            str = str.substring(1, str.length()-1);
            String[] x = str.split(",");

            char pos = 's';
            int len = n;
            int result = 0;
            int cnt_s = 0;
            int cnt_e = x.length-1;

//            System.out.println(Arrays.toString(x));

            for(int i=0; i<p.length(); i++) {
                if(p.charAt(i) == 'R') {
                    pos = (pos == 's') ? 'e' : 's';
                } else {
                    len--;
                    if(len < 0) {
                        result = -1;
                        break;
                    }

                    if(pos == 's') cnt_s++;
                    else cnt_e--;
                }
            }

            if(result == -1) {
                sb.append("error" + "\n");
            } else {
                result(x, pos, cnt_s, cnt_e);
            }
        }

        System.out.println(sb);
    }

    static void result(String[] x, char pos, int cnt_s, int cnt_e) {
        sb.append("[");

        if(pos == 's' && cnt_s < x.length) {
            sb.append(x[cnt_s]);
            for(int i=cnt_s+1; i<=cnt_e; i++) {
                sb.append(","+x[i]);
            }
        } else if(pos == 'e' && cnt_e >= 0) {
            sb.append(x[cnt_e]);
            for(int i=cnt_e-1; i>=cnt_s; i--) {
                sb.append(","+x[i]);
            }
        }

        sb.append("]" + "\n");
    }
}
