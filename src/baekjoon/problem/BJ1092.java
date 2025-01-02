package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1092 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Integer[] craneArray = new Integer[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			craneArray[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(craneArray, ((o1, o2) -> o2 - o1));

		int M = Integer.parseInt(br.readLine());

		List<Integer> cargoList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for(int i = 0; i < M; i++) {
			cargoList.add(Integer.valueOf(st.nextToken()));
		}

		cargoList.sort(((o1, o2) -> o2 - o1));

		// 크레인보다 화물이 더 큰 게 있는 경우
		if(cargoList.get(0) > craneArray[0]) {
			System.out.println(-1);
			return;
		}

		int count = 0;
		while(!cargoList.isEmpty()) {

			count++;

			int cargoIndex = 0;

			for(int i = 0; i < N; ) {

				if(cargoIndex == cargoList.size()) {
					break;
				}

				if(craneArray[i] >= cargoList.get(cargoIndex)) {
					cargoList.remove(cargoIndex);
					i++;
				}
				else {
					cargoIndex++;
				}
			}
		}

		System.out.println(count);
	}
}
