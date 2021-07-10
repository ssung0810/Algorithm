package Programmers.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/* 크레인 인형뽑기 게임
 * Created by qkrtjdcjf124
 * Date : 2021/07/10
 */
public class ClawMachine {
	/*  <입력>
	 *  5
		0 0 0 0 0
		0 0 1 0 3
		0 2 5 0 1
		4 2 4 4 2
		3 5 1 3 1
		8
		1 5 3 5 1 2 1 4
		
		<출력>
		4
	*/
	static int[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		int N = Integer.parseInt(bf.readLine());
		board = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine(), " ");
			
			for(int j=0; j<N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int M = Integer.parseInt(bf.readLine());
		int[] moves = new int[M];
		st = new StringTokenizer(bf.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}
		
		//=======================================================
		Stack<Integer> basket = new Stack<>();
		
		for(int i=0; i<moves.length; i++) {
			int column = moves[i]-1;
			
			for(int y=0; y<board[0].length; y++) {
				int num = board[y][column];
				
				if(num != 0) {
					if(basket.size() != 0 && basket.peek() == num) {
						basket.pop();
						answer += 2;
					} else {
						basket.push(num);
					}
					
					board[y][column] = 0;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}

}
