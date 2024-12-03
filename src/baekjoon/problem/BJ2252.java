package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2252 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] inDegree = new int[N + 1];
		Arrays.fill(inDegree, 0);
		List<List<Integer>> connectionInfo = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			connectionInfo.add(new ArrayList<>());
		}

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			connectionInfo.get(A).add(B);
			inDegree[B]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		int[] result = new int[N];

		for(int i = 1; i < N + 1; i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
			}
		}

		for(int i = 1; i < N + 1; i++) {
			if(queue.isEmpty()) {
				break;
			}

			int current = queue.poll();
			result[i - 1] = current;

			for(int a : connectionInfo.get(current)) {
				inDegree[a]--;
				if(inDegree[a] == 0) {
					queue.add(a);
				}
			}
		}

		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append(" ");
		}

		System.out.println(sb);
	}
}
