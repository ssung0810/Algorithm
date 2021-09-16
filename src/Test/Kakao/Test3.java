package Test.Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int[] fees = new int[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            fees[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(bf.readLine());
        String[] records = new String[M];
        for(int i=0; i<M; i++) {
            records[i] = bf.readLine();
        }

        ////////////////////////////////

        int[] answer = {};
        HashMap<String , String> car = new HashMap<>();
        HashMap<String , Integer> time = new HashMap<>();
        String[] park = new String[3];

        for(int i=0; i<records.length; i++) {
            park = records[i].split(" ");

            if(park[2].equals("IN")) {
                car.put(park[1], park[0]);
            } else {
                String a = car.get(park[1]);
                String b = park[0];

                int t = calcTime(a, b);

                time.put(park[1], time.getOrDefault(park[1], 0) + t);
                car.remove(park[1]);
            }
        }

        if(car.size() != 0) {
            for(String k : car.keySet()) {
                String a = car.get(k);
                String b = "23:59";

                int t = calcTime(a, b);

                time.put(k, time.getOrDefault(k, 0) + t);
                car.remove(k);
            }
        }

        int[][] carList = new int[time.size()][2];
        int cnt = 0;
        for(String k : time.keySet()) {
            carList[cnt][0] = Integer.parseInt(k);
            if(time.get(k) > fees[0]) {
                double a = Math.ceil((double)(time.get(k)-fees[0]) / fees[2]);
                int b = (int)a * fees[3];
                carList[cnt][1] = b + fees[1];
            } else {
                carList[cnt][1] = fees[1];
            }
            cnt++;
        }

        Arrays.sort(carList, (e1, e2) -> {
            return e1[0] - e2[0];
        });

        answer = new int[carList.length];
        for(int i=0; i<carList.length; i++) {
            answer[i] = carList[i][1];
        }

        System.out.println(Arrays.toString(answer));
    }

    static int calcTime(String a, String b) {
        int hour = Integer.parseInt(b.split(":")[0]) - Integer.parseInt(a.split(":")[0]);
        int minute = 0;

        int a_min = Integer.parseInt(a.split(":")[1]);
        int b_min = Integer.parseInt(b.split(":")[1]);
        if(a_min > b_min) {
            minute = b_min + 60 - a_min;
            hour--;
        } else {
            minute = b_min - a_min;
        }

        int answer = (hour*60) + minute;

        return answer;
    }
}
