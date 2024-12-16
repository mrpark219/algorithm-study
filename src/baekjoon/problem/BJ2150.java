package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2150 {

	public static final int MAX = 10001;

	public static int id = 0;
	public static int[] d = new int[MAX];
	public static boolean[] finished = new boolean[MAX];
	public static List<Integer>[] connectionInfo = new List[MAX];
	public static List<List<Integer>> SCC = new ArrayList<>();
	public static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		for(int i = 0; i < connectionInfo.length; i++) {
			connectionInfo[i] = new ArrayList<>();
		}

		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			connectionInfo[A].add(B);
		}

		for(int i = 1; i <= V; i++) {
			if(d[i] == 0) {
				dfs(i);
			}
		}

		SCC.sort((o1, o2) -> o1.get(0) - o2.get(0));

		sb.append(SCC.size()).append("\n");
		for(List<Integer> scc : SCC) {
			for(int s : scc) {
				sb.append(s).append(" ");
			}
			sb.append("-1").append("\n");
		}

		System.out.println(sb);
	}

	public static int dfs(int x) {

		// 노드마다 고유한 번호를 할당
		d[x] = ++id;

		// 스택에 자기 자신을 삽입
		stack.push(x);

		int parent = d[x];
		for(int y : connectionInfo[x]) {
			// 방문하지 않은 이웃
			if(d[y] == 0) {
				parent = Math.min(parent, dfs(y));
			}
			// 처리 중인 이웃
			else if(!finished[y]) {
				parent = Math.min(parent, d[y]);
			}
		}


		// 부모 노드가 자기 자신인 경우
		if(parent == d[x]) {
			List<Integer> scc = new ArrayList<>();
			while(true) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				if(t == x) {
					break;
				}
			}

			Collections.sort(scc);
			SCC.add(scc);
		}

		return parent;
	}
}
