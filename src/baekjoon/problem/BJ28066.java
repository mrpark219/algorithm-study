package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ28066 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		while(queue.size() >= K) {

			queue.offer(queue.poll());
			for(int i = 0; i < K - 1; i++) {
				queue.poll();
			}
		}

		System.out.println(queue.poll());
	}
}
