package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ5904 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int length = 3;
		int prev;
		int k = 0;

		while(length < N) {
			k++;
			prev = length;
			length = 2 * prev + (k + 3);
		}

		dfs(N, length, k);
	}

	public static void dfs(int n, int length, int k) {

		int prev = (length - (1 + 2 + k)) / 2;

		if(k == 0) {
			if(n == 1) {
				System.out.print("m");
				return;
			}
			else {
				System.out.print("o");
				return;
			}
		}
		if(n <= prev) {
			dfs(n, prev, k - 1);
		}
		else if(prev + 1 <= n && n < prev + (1 + 2 + k)) {
			if(prev + 1 == n) {
				System.out.print('m');
			}
			else {
				System.out.print('o');
			}
		}
		else {
			n -= (prev + (1 + 2 + k));
			dfs(n, prev, k - 1);
		}
	}
}