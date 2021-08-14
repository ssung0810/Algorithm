package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 프린터
 * Date : 2021/08/13
 */
public class Printer {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] priorities = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            priorities[i] = Integer.parseInt(st.nextToken());
        }

        int location = Integer.parseInt(bf.readLine());

        ///////////////////////////////////////

        int answer = 0;
        LinkedList<print> q = new LinkedList<>();

        for(int i=0; i<priorities.length; i++) {
            q.add(new print(i, priorities[i]));
        }

        while(!q.isEmpty()) {
            print p = q.pop();
            int num = p.important;
            boolean isMax = false;

            for(int i=0; i<q.size(); i++) {
                if(num < q.get(i).important) {
                    q.add(p);

                    for(int j=0; j<i; j++) {
                        q.add(q.pop());
                    }

                    break;
                }

                if(i == q.size()-1) isMax = true;
            }

            if(isMax) {
                answer++;

                if(location == p.pos) break;
            }
        }

        System.out.println(answer);
    }
}

class print {
    int pos;
    int important;

    print(int pos, int important) {
        this.pos = pos;
        this.important = important;
    }
}
