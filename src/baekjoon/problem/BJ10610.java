package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ10610 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String N = br.readLine();

		Integer[] array = new Integer[N.length()];

		boolean isOk = false;
		int sum = 0;

		for(int i = 0; i < N.length(); i++) {
			array[i] = Integer.parseInt(String.valueOf(N.charAt(i)));
			sum += array[i];
			if(array[i] == 0) {
				isOk = true;
			}
		}

		if(!isOk || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}

		Arrays.sort(array, (((o1, o2) -> o2 - o1)));

		for(int i = 0; i < N.length(); i++) {
			sb.append(array[i]);
		}

		System.out.println(sb);
	}
}
