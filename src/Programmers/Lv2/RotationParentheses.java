package Programmers.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/* 괄호 회전하기
 * Date : 21021/01/08
 */
public class RotationParentheses {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();

        ///////////////////////////////////////////

        int answer = 0;

        char[] arr = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            leftShift(arr);
            System.out.println(new String(arr));
            if(rightCheck(arr)) answer++;
        }

        System.out.println(answer);
    }

    static void leftShift(char[] arr) {
        char c = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length-1] = c;
    }

    static boolean rightCheck(char[] arr) {
        Stack<Character> s = new Stack<>();
        char flag = '0';

        for(char t : arr) {
            if(t == '[' || t == '{' || t == '(') {
                s.add(t);
                flag = t;
            } else {
                if(s.isEmpty()) return false;

                char flag2 = '0';
                if(t == ']') flag2 = '[';
                else if(t == '}') flag2 = '{';
                else if(t == ')') flag2 = '(';

                if(s.peek() == flag2) s.pop();
                else return false;
            }
        }

        if(!s.isEmpty()) return false;

        return true;
    }
}
