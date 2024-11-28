package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2644 {

	public static List<List<Integer>> relation = new ArrayList<>();
	public static boolean[] visit;
	public static int result = -1;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		visit = new boolean[n + 1];
		for(int i = 0; i <= n; i++) {
			relation.add(new ArrayList<>());
		}

		StringTokenizer st = new StringTokenizer(br.readLine());

		int answerX = Integer.parseInt(st.nextToken());
		int answerY = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			relation.get(x).add(y);
			relation.get(y).add(x);
		}

		dfs(answerX, answerY, 0);

		System.out.println(result);
	}

	public static void dfs(int x, int y, int count) {
		if(x == y) {
			result = count;
			return;
		}

		visit[x] = true;
		for(int i = 0; i < relation.get(x).size(); i++) {
			int next = relation.get(x).get(i);
			if(!visit[next]) {
				dfs(next, y, count + 1);
			}
		}
	}
}
