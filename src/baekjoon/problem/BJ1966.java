package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ1966 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			LinkedList<int[]> queue = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < N; i++) {
				queue.offer(new int[]{i, Integer.parseInt(st.nextToken())});
			}

			int count = 0;

			while(!queue.isEmpty()) {

				int[] current = queue.poll();
				boolean isMax = true;

				for(int i = 0; i < queue.size(); i++) {

					if(current[1] < queue.get(i)[1]) {

						queue.offer(current);
						for(int j = 0; j < i; j++) {
							queue.offer(queue.poll());
						}

						isMax = false;
						break;
					}
				}

				if(!isMax) {
					continue;
				}

				count++;

				if(current[0] == M) {
					break;
				}
			}

			sb.append(count).append("\n");
		}

		System.out.println(sb);
	}
}
