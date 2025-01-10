package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1005 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] timeArray = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				timeArray[i] = Integer.parseInt(st.nextToken());
			}

			int[] inDegree = new int[N + 1];
			List<List<Integer>> connectionList = new ArrayList<>();

			for(int i = 0; i <= N; i++) {
				connectionList.add(new ArrayList<>());
			}

			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				inDegree[B]++;
				connectionList.get(A).add(B);
			}

			int W = Integer.parseInt(br.readLine());

			Queue<Integer> queue = new LinkedList<>();
			int[] dp = new int[N + 1];

			// 차수 0
			for(int i = 1; i <= N; i++) {
				if(inDegree[i] == 0) {
					queue.offer(i);
					dp[i] = timeArray[i];
				}
			}

			// 위상 정렬 시작

			while(!queue.isEmpty()) {

				int current = queue.poll();

				for(int b : connectionList.get(current)) {

					inDegree[b]--;
					dp[b] = Math.max(dp[b], dp[current] + timeArray[b]);

					if(inDegree[b] == 0) {
						queue.add(b);
					}
				}

				if(current == W) {
					break;
				}
			}

			sb.append(dp[W]).append("\n");
		}

		System.out.println(sb);
	}
}
