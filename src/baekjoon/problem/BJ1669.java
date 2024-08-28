package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1669 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());

		int gap = Y - X;
		if(gap == 0) {
			System.out.println(0);
			return;
		}
		int max = (int) Math.sqrt(gap);

		int count;
		if(max == Math.sqrt(gap)) {
			count = max * 2 - 1;
		}
		else {
			if(max * max + max < gap) {
				count = max * 2 + 1;
			}
			else {
				count = max * 2;
			}
		}

		System.out.println(count);
	}
}
