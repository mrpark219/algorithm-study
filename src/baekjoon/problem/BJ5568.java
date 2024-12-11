package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ5568 {

	public static int n;
	public static int k;
	public static boolean[] visited;
	public static String[] input;
	public static ArrayList<String> resultList = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		visited = new boolean[n];
		input = new String[n];
		for(int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}

		dfs(0, "");

		System.out.println(resultList.size());
	}

	public static void dfs(int count, String temp) {

		if(count == k) {
			if(!resultList.contains(temp)) {
				resultList.add(temp);
			}
			return;
		}

		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(count + 1, temp + input[i]);
				visited[i] = false;
			}
		}
	}
}
