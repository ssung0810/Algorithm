package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

/* 순위 검색
 * Date : 2021/09/26
 */
public class RankingSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        String[] info = new String[N];
        for(int i=0; i<N; i++) {
            info[i] = bf.readLine();
        }

        int M = Integer.parseInt(bf.readLine());
        String[] query = new String[N];
        for(int i=0; i<M; i++) {
            query[i] = bf.readLine();
        }

        /////////////////////////////////////////////

        int[] answer = new int[query.length];

        for(int i=0; i<info.length; i++) {
            String[] infoArr = info[i].split(" ");
            int score = Integer.parseInt(infoArr[4]);

            for(int j=0; j<query.length; j++) {
                String[] arr = query[j].replaceAll("and ", "").split(" ");
                int cnt = 0;
                int result = 0;

                for(int q=0; q<arr.length; q++) {
                    if(!arr[q].equals("-")) {
                        if (q == 4) {
                            if (score >= Integer.parseInt(arr[q])) {
                                result++;
                            }
                        } else if(infoArr[q].equals(arr[q])) {
                            result++;
                        }

                        cnt++;
                    }
                }

                if(result == cnt) answer[j]++;
            }
        }

//        for(int i=0; i<query.length; i++) {
//            String[] arr = query[i].replaceAll("and ", "").split(" ");
//            int cnt = 0;
//
//            for(int j=0; j<arr.length; j++) {
//                if(!arr[j].equals("-")) {
////                    box.add(arr[j]);
//
//                    for(int k=0; k<info.length; k++) {
//                        if(j == 4) {
//                            int num = Integer.parseInt(info[k].split(" ")[4]);
//                            if (num >= Integer.parseInt(arr[j])) {
//                                success[k]++;
//                            }
//                        } else if(box.add(info[k]) == true) {
//                            System.out.println(arr[j] + " :: " + info[k]);
//                            success[k]++;
//                        }
//                        } else if(info[k].contains(arr[j])) {
//                            success[k]++;
//                        }
//                    }
//                    cnt++;
////                    box.clear();
//                }
//            }
//
//            int result = 0;
//            for(int q=0; q< success.length; q++) {
//                if(success[q] == cnt) result++;
//                success[q] = 0;
//            }
//            answer[i] = result;
//        }

        for(int num : answer) {
            System.out.print(num + " ");
        }
    }
}
