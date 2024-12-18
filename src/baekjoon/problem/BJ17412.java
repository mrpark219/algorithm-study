package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17412 {

	public static int N;
	public static int P;
	public static int[][] capacity;
	public static int[][] flow;

	static List<Integer>[] connectionInfo;
	static int[] visited;
	static int result = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		capacity = new int[N + 1][N + 1];
		flow = new int[N + 1][N + 1];
		visited = new int[N + 1];
		connectionInfo = new List[N + 1];
		for(int i = 0; i <= N; i++) {
			connectionInfo[i] = new ArrayList<>();
		}

		for(int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			connectionInfo[A].add(B);
			connectionInfo[B].add(A);

			capacity[A][B] = 1;
		}

		result = 0;

		networkFlow(1, 2);

		System.out.println(result);
	}

	public static void networkFlow(int start, int end) {

		while(true) {

			Queue<Integer> queue = new LinkedList<>();
			Arrays.fill(visited, -1);
			queue.offer(start);

			while(!queue.isEmpty()) {

				int current = queue.poll();

				for(int next : connectionInfo[current]) {

					if(capacity[current][next] - flow[current][next] > 0 && visited[next] == -1) {

						queue.offer(next);
						visited[next] = current;

						if(next == end) {
							break;
						}
					}
				}
			}

			if(visited[end] == -1) {
				break;
			}

			// 유량이 1이 아닌 경우
			/*
			int f = Integer.MAX_VALUE;
			for(int i = end; i != start; i = visited[i]) {
				f = Math.min(f, capacity[visited[i]][i] - flow[visited[i]][i]);
			}
			*/

			for(int i = end; i != start; i = visited[i]) {
				flow[visited[i]][i] += 1;
				flow[i][visited[i]] -= 1;
			}

			//result += f;
			result += 1;
		}
	}
}
