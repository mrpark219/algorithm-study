package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ3980 {

	public static boolean[] visited = new boolean[11];
	public static int[][] positionArray = new int[11][11];
	public static int max = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int C = Integer.parseInt(br.readLine());

		while(C-- > 0) {

			Arrays.fill(visited, false);
			max = 0;

			for(int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for(int j = 0; j < 11; j++) {
					positionArray[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0, 0);

			sb.append(max).append("\n");
		}

		System.out.println(sb);
	}

	public static void dfs(int count, int sum) {

		if(count == 11) {
			max = Math.max(max, sum);
			return;
		}

		for(int i = 0; i < 11; i++) {
			if(!visited[i] && positionArray[count][i] > 0) {
				visited[i] = true;
				dfs(count + 1, sum + positionArray[count][i]);
				visited[i] = false;
			}
		}
	}
}
