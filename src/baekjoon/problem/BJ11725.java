package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11725 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] parent = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		List<List<Integer>> tree = new ArrayList<>();
		for(int i = 0; i < N + 1; i++) {
			tree.add(new ArrayList<>());
		}

		for(int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			tree.get(A).add(B);
			tree.get(B).add(A);
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while(!queue.isEmpty()) {
			int node = queue.poll();
			for(int connect : tree.get(node)) {
				if(!visited[connect]) {
					visited[connect] = true;
					parent[connect] = node;
					queue.add(connect);
				}
			}
		}

		for(int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}

		System.out.print(sb);
	}
}
