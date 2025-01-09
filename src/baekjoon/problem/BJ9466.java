package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ9466 {

	public static int[] studentArray;
	public static boolean[] visited;
	public static boolean[] done;
	public static int count;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		while(T-- > 0) {

			int n = Integer.parseInt(br.readLine());

			count = 0;
			studentArray = new int[n + 1];
			visited = new boolean[n + 1];
			done = new boolean[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int i = 1; i <= n; i++) {
				studentArray[i] = Integer.parseInt(st.nextToken());
			}

			for(int i = 1; i <= n; i++) {
				if(!done[i]) {
					dfs(i);
				}
			}

			sb.append(n - count).append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int n) {

		if(visited[n]) {
			done[n] = true;
			count++;
		}
		else {
			visited[n] = true;
		}

		if(!done[studentArray[n]]) {
			dfs(studentArray[n]);
		}

		visited[n] = false;
		done[n] = true;
	}
}
