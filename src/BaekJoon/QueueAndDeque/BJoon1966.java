package BaekJoon.QueueAndDeque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/* 프린터 큐
 * Created by qkrtjdcjf124
 * Date : 2021/08/14
 */
public class BJoon1966 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		for(int m=0; m<N; m++) {
			st = new StringTokenizer(bf.readLine());
			int M = Integer.parseInt(st.nextToken());
			int location = Integer.parseInt(st.nextToken());
			int[] priorities = new int[M];

			st = new StringTokenizer(bf.readLine());
			for (int i = 0; i < M; i++) {
				priorities[i] = Integer.parseInt(st.nextToken());
			}

			int answer = 0;
			LinkedList<print2> q = new LinkedList<>();

			for (int i = 0; i < priorities.length; i++) {
				q.add(new print2(i, priorities[i]));
			}

			while (!q.isEmpty()) {
				print2 p = q.pop();
				int num = p.important;
				boolean isMax = true;

				for (int i = 0; i < q.size(); i++) {
					if (num < q.get(i).important) {
						q.add(p);

						for (int j = 0; j < i; j++) {
							q.add(q.pop());
						}

						isMax = false;
						break;
					}
				}

				if (isMax) {
					answer++;

					if (location == p.pos) {
						sb.append(answer + "\n");
						break;
					}
				}
			}
		}

		System.out.println(sb);
	}

}

class print2 {
	int pos;
	int important;

	print2(int pos, int important) {
		this.pos = pos;
		this.important = important;
	}
}
