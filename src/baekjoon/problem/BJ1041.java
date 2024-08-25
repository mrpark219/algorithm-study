package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1041 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] array = new int[6];

		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		int maxIndex = 0;
		int min1 = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			min1 = Math.min(min1, array[i]);
			if(array[i] > max) {
				max = array[i];
				maxIndex = i;
			}
		}

		long count = 0;
		if(N == 1) {
			for(int i = 0; i < 6; i++) {
				if(maxIndex == i) {
					continue;
				}
				count += array[i];
			}
		}
		else {
			// E - B -> 4 - 1
			// A = F -> 0 - 5
			// C - D -> 2 - 3

			int min2 = Integer.MAX_VALUE;
			int min3 = Integer.MAX_VALUE;

			for(int i = 0; i < 6; i++) {
				for(int j = 0; j < 6; j++) {
					if(i == j || !check(i, j)) {
						continue;
					}

					min2 = Math.min(min2, (array[i] + array[j]));

					for(int z = 0; z < 6; z++) {
						if(i == z || j == z || !check(i, z) || !check(j, z)) {
							continue;
						}

						min3 = Math.min(min3, (array[i] + array[j] + array[z]));
					}
				}
			}

			count = 4L * min3 + ((N - 2) * 8L + 4) * min2 + ((long) Math.pow((N - 2), 2) * 5L + (N - 2) * 4L) * min1;
		}

		System.out.println(count);
	}

	public static boolean check(int indexA, int indexB) {
		if(indexA == 0 && indexB == 5 || indexA == 5 && indexB == 0) {
			return false;
		}
		else if(indexA == 2 && indexB == 3 || indexA == 3 && indexB == 2) {
			return false;
		}
		else if(indexA == 1 && indexB == 4 || indexA == 4 && indexB == 1) {
			return false;
		}

		return true;
	}
}
