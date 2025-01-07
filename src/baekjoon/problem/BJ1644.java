package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ1644 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		boolean[] isPrimeArray = new boolean[N + 1];
		for(int i = 2; i * i <= N; i++) {
			if(!isPrimeArray[i]) {
				for(int j = i * 2; j <= N; j += i) {
					isPrimeArray[j] = true;
				}
			}
		}

		List<Integer> primeList = new ArrayList<>();
		for(int i = 2; i <= N; i++) {
			if(!isPrimeArray[i]) {
				primeList.add(i);
			}
		}

		int start = 0;
		int end = 0;
		int sum = 0;
		int count = 0;

		while(true) {

			if(sum == N) {
				count++;
				sum -= primeList.get(start);
				start++;
			}
			else if(sum > N) {
				sum -= primeList.get(start);
				start++;
			}
			else {
				if(end >= primeList.size()) {
					break;
				}
				sum += primeList.get(end);
				end++;
			}
		}

		System.out.println(count);
	}
}
