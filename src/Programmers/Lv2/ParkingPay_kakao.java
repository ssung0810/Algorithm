package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/* 주차 요금 계선
 * Date : 2022/01/25
 */
public class ParkingPay_kakao {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int[] fees = new int[4];
        for(int i=0; i<4; i++) {
            fees[i] = Integer.parseInt(st.nextToken());
        }
        int n = Integer.parseInt(bf.readLine());
        String[] records = new String[n];
        for(int i=0; i<n; i++) {
            records[i] = bf.readLine();
        }

        //////////////////////////////////////////////

        int[] answer = {};

        HashMap<String, String> park = new HashMap<>();
        TreeMap<String, Integer> pay = new TreeMap<>();

        for (int i = 0; i < records.length; i++) {
            String[] arr = records[i].split(" ");

            if (arr[2].equals("IN")) {
                park.put(arr[1], arr[0]);
            } else {
                String key = arr[1];
                int p = pay(park.get(key), arr[0]);
                pay.put(key, pay.getOrDefault(key, 0) + p);
                park.remove(key);
            }
        }

        for (String key : park.keySet()) {
            int p = pay(park.get(key), "23:59");
            pay.put(key, pay.getOrDefault(key, 0) + p);
        }

        answer = new int[pay.size()];

        int defaultTime = fees[0];
        int defaultMoney = fees[1];
        int payTime = fees[2];
        int payMoney = fees[3];
        int cnt = 0;
        for (String key : pay.keySet()) {
            if(pay.get(key) <= defaultTime) {
                answer[cnt] = defaultMoney;
            } else {
                int num = pay.get(key)-defaultTime;
                answer[cnt] = defaultMoney + (num%payTime > 0 ? num/payTime+1 : num/payTime) * payMoney;
            }

            cnt++;
        }

        System.out.println(Arrays.toString(answer));
    }

    static int pay(String in, String out) {
        String[] in_arr = in.split(":");
        String[] out_arr = out.split(":");

        int a = Integer.parseInt(in_arr[0]) * 60 + Integer.parseInt(in_arr[1]);
        int b = Integer.parseInt(out_arr[0]) * 60 + Integer.parseInt(out_arr[1]);

        return b-a;
    }
}
