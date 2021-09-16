package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 듣보잡
 * Date : 2021/09/16
 */
public class BJoon1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> n = new HashSet<>();
        for(int i=0; i<N; i++) {
            n.add(bf.readLine());
        }

        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<M; i++) {
            String txt = bf.readLine();
            if(!n.add(txt)) {
                arr.add(txt);
            }
        }

        Collections.sort(arr);

        sb.append(arr.size() + "\n");
        for(String txt : arr) {
            sb.append(txt + "\n");
        }

        System.out.println(sb);
    }
}
