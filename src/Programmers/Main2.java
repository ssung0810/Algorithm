package Programmers;

import java.util.*;

public class Main2 {
	static int min = Integer.MAX_VALUE;
	static int[][] box;

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

		int[] answer = solution(rows, columns, queries);

		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];

		box = new int[rows][columns];
		for(int i=0, cnt=1; i<rows; i++) {
			for(int j=0; j<columns; j++, cnt++) {
				box[i][j] = cnt;
			}
		}

		for (int i=0; i< queries.length; i++) {
			rotation(queries[i], rows);
			answer[i] = min;
			min = Integer.MAX_VALUE;
		}

		return answer;
	}

	static void rotation(int[] query, int rows) {
		int val = box[query[0]-1][query[1]-1];
		min = Math.min(min, val);

		bottomRotation(query[0], query[1]-1, query[2]-query[0], rows);
		rightRotation(query[2]-1, query[1], query[3]-query[1], rows);
		topRotation(query[2]-2, query[3]-1, query[2]-query[0], rows);
		leftRotation(query[0]-1, query[3]-2, query[3]-query[1], rows);

		box[query[0] - 1][query[1]] = val;

		for (int[] ints : box) {
			System.out.println(Arrays.toString(ints));
		}
		System.out.println("---------");
	}

	static void bottomRotation(int row, int col, int cnt, int rows) {
		for(int i=1; i<=cnt; i++, row++) {
			box[row-1][col] = box[row][col];
			min = Math.min(min, box[row][col]);
		}
	}
	static void rightRotation(int row, int col, int cnt, int rows) {
		for(int i=1; i<=cnt; i++, col++) {
			box[row][col-1] = box[row][col];
			min = Math.min(min, box[row][col]);
		}
	}
	static void topRotation(int row, int col, int cnt, int rows) {
		for(int i=1; i<=cnt; i++, row--) {
			box[row+1][col] = box[row][col];
			min = Math.min(min, box[row][col]);
		}
	}
	static void leftRotation(int row, int col, int cnt, int rows) {
		for(int i=1; i<cnt; i++, col--) {
			box[row][col+1] = box[row][col];
			min = Math.min(min, box[row][col]);
		}
	}
}