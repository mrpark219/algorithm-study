package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1049 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int min6 = 1001;
		int min1 = 1001;

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int price6 = Integer.parseInt(st.nextToken());
			int price1 = Integer.parseInt(st.nextToken());

			min6 = Math.min(min6, price6);
			min1 = Math.min(min1, price1);
		}

		int cost = 0;

		if(min6 >= min1 * 6) {
			cost = N * min1;
		}
		else {
			cost += (N / 6) * min6;
			cost += Math.min((N % 6) * min1, min6);
		}

		System.out.println(cost);
	}
}
