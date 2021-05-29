package BaekJoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* LCS
 * Created by qkrtjdcjf124
 * Date : 2021/05/29
 */
public class BJoon9251 {
	static String[] arr1, arr2;
	static Integer[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		String[] strArr;
		
		str = bf.readLine();
		strArr = str.split("");
		arr1 = new String[str.length()];
		for(int i=0; i<arr1.length; i++) {
			arr1[i] = strArr[i];
		}
		
		str = bf.readLine();
		strArr = str.split("");
		arr2 = new String[str.length()];
		for(int i=0; i<arr2.length; i++) {
			arr2[i] = strArr[i];
		}
		
		dp = new Integer[arr1.length][arr2.length];
		
		
		dp[0][0] = 0;
		LCS(arr1.length-1, arr2.length-1);
		
		System.out.println(dp[arr1.length-1][arr2.length-1]);
	}

	static int LCS(int x, int y) {
		if(x < 0 || y < 0) {
			return 0;
		}
		
		if(dp[x][y] == null) {
			if(arr1[x].equals(arr2[y])) {
				dp[x][y] = LCS(x-1, y-1) + 1;
			} else {
				dp[x][y] = Math.max(LCS(x-1, y), LCS(x, y-1));
			}
		}
		
		return dp[x][y];
	}
}
