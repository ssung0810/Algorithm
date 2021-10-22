package BaekJoon.Etc.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* IPv6
 * Date : 2021/10/21
 */
public class BJoon3107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = bf.readLine();
        String[] arr = s.split(":");

        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("") && arr[i+1].equals("")) {
                for(int j=arr.length-2; j<8; j++) {
                    sb.append("0000:");
                }
                i++;
            } else if(arr[i].equals("")) {
                for(int j=arr.length-1; j<8; j++) {
                    sb.append("0000:");
                }
            } else if(arr[i].length() < 4) {
                for(int j=arr[i].length(); j<4; j++) {
                    sb.append("0");
                }
                sb.append(arr[i] + ":");
            } else {
                sb.append(arr[i] + ":");
            }
        }

        if(s.charAt(s.length()-2) == ':' && s.charAt(s.length()-1) == ':') {
            for(int i=arr.length; i<8; i++) {
                sb.append("0000:");
            }
        }

        sb.deleteCharAt(sb.lastIndexOf(":"));
        System.out.println(sb);
    }
}
