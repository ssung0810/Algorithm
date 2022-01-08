package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 빛의 경로 사이클
 * Date : 2021/12/29
 */
public class PathCycleOfLight {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        String[] grid = new String[st.countTokens()];
        int n = st.countTokens();
        for(int i=0; i<n; i++) {
            grid[i] = st.nextToken();
        }

        ///////////////////////////////////////////////////

        HashSet<String> set = new HashSet<>();
        char[][] arr = new char[grid.length][grid[0].length()];

        for(int i=0; i< grid.length; i++) {
            arr[i] = grid[i].toCharArray();
        }

        char[] m_arr = {'B', 'T', 'L', 'R'};
        ArrayList<Integer> result = new ArrayList<>();

//        for(int i=0; i<arr.length; i++) {
//            for(int j=0; j<arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }
        for(int p=0; p<arr.length; p++) {
            for(int q=0; q<arr[0].length; q++) {
                for(int i=0; i<4; i++) {
                    char m = m_arr[i];
                    int row = p;
                    int col = q;
                    boolean ck = true;
                    int cnt = 0;

                    while (true) {
                        String t = row + "," + col;

                        if (m == 'B') {
                            if (row + 1 < arr.length) row++;
                            else row = 0;
                        } else if (m == 'T') {
                            if (row - 1 >= 0) row--;
                            else row = arr.length - 1;
                        } else if (m == 'L') {
                            if (col - 1 >= 0) col--;
                            else col = arr[0].length - 1;
                        } else {
                            if(col + 1 < arr[0].length) col++;
                            else col = 0;
                        }

                        m = move(m, arr[row][col]);
                        char dis = arr[row][col];

//                if(dis == 'S') m=m;
//                else if(m == 'B' && dis == 'R') m = 'L';
//                else if(m == 'B' && dis == 'L') m = 'R';
//                else if(m == 'T' && dis == 'R') m = 'R';
//                else if(m == 'T' && dis == 'L') m = 'L';
//                else if(m == 'L' && dis == 'R') m = 'T';
//                else if(m == 'L' && dis == 'L') m = 'B';
//                else if(m == 'R' && dis == 'R') m = 'B';
//                else if(m == 'R' && dis == 'L') m = 'T';

                        ck = set.add(t + "-" + row + "," + col+m);

                        if(!ck) break;

                        cnt++;
//                System.out.println(t + " :: " + row + " :: " + col + " :: " + result.get(i) + " :: " + m);
                    }
                    if(cnt > 0) result.add(cnt);
//            System.out.println();
                }
            }
        }


        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        Arrays.sort(answer);

        System.out.println(Arrays.toString(answer));
    }

    static char move(char m, char dis) {
        if(dis == 'S') return m;

        if(m == 'B' && dis == 'R') return 'L';
        else if(m == 'B' && dis == 'L') return 'R';
        if(m == 'T' && dis == 'R') return 'R';
        else if(m == 'T' && dis == 'L') return 'L';
        if(m == 'L' && dis == 'R') return 'T';
        else if(m == 'L' && dis == 'L') return 'B';
        if(m == 'R' && dis == 'R') return 'B';
        else if(m == 'R' && dis == 'L') return 'T';

        return '0';
    }
}
