package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int M = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++) {
            sb.append(search(Integer.parseInt(st.nextToken()), arr) + "\n");
        }

        System.out.println(sb);
    }

    static int search(int N, int[] arr) {
        int start=0, end=arr.length-1, mid=(start+end)/2;

        while(mid < end) {
            if(N < arr[mid]) {
                end = mid - 1;
                mid = (start + end) / 2;
            } else if(N > arr[mid]) {
                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                break;
            }
        }

        return N == arr[mid] ? 1 : 0;
    }
}