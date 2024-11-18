package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12851 {

	public static int minTime = Integer.MAX_VALUE;
	public static int minCount = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		bfs(N, K);

		System.out.println(minTime + "\n" + minCount);
	}

	public static void bfs(int N, int K) {

		int MAX = 100000;

		Queue<Integer> queue = new LinkedList<>();
		int[] visited = new int[MAX + 1];
		int[] count = new int[MAX + 1];

		Arrays.fill(visited, -1);

		visited[N] = 0;
		count[N] = 1;
		queue.add(N);

		while(!queue.isEmpty()) {
			int current = queue.poll();

			int[] nextPositions = {current - 1, current + 1, current * 2};

			for(int nextPos : nextPositions) {

				if(nextPos < 0 || nextPos > 100000) {
					continue;
				}

				if(visited[nextPos] == -1) {
					visited[nextPos] = visited[current] + 1;
					count[nextPos] = count[current];
					queue.add(nextPos);
				}
				else if(visited[nextPos] == visited[current] + 1) {
					count[nextPos] += count[current];
				}
			}
		}

		minTime = visited[K];
		minCount = count[K];
	}
}
