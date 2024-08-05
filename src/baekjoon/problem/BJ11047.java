package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ11047 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;

		Integer[] unitArray = new Integer[N];

		for(int i = 0; i < N; i++) {
			unitArray[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(unitArray, Comparator.reverseOrder());

		int index = 0;
		while(K != 0) {

			int quotient = K / unitArray[index];

			if(quotient > 0) {
				count += quotient;
				K = K % unitArray[index];
			}

			index++;
		}

		System.out.println(count);
	}
}
