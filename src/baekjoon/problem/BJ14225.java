package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14225 {

	public static int[] array;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		array = new int[N];
		visited = new boolean[100000 * 20 + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, N, 0);

		for(int i = 1;i<visited.length;i++) {
			if(!visited[i]) {
				System.out.println(i);
				break;
			}
		}
	}

	public static void dfs(int depth, int endDepth, int count) {

		if(depth == endDepth) {
			visited[count] = true;
			return;
		}

		dfs(depth + 1, endDepth, count);
		dfs(depth + 1, endDepth, count + array[depth]);
	}
}
