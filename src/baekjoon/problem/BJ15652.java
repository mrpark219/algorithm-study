package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ15652 {

	public static StringBuffer sb = new StringBuffer();
	public static int[] arr;
	public static int num = 1;
	public static int N;
	public static int M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		solve(1);

		System.out.println(sb);
	}

	public static void solve(int count) {

		if(count > M) {
			for(int i : arr) {
				sb.append(i).append(" ");
			}
			sb.append("\n");
			return;
		}

		for(int i = num; i <= N; i++) {
			arr[count - 1] = i;
			num = i;
			solve(count + 1);
		}
	}
}
