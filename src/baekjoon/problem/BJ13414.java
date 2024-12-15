package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class BJ13414 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

		for(int i = 0; i < L; i++) {
			String studentNumber = br.readLine();

			if(linkedHashSet.contains(studentNumber)) {
				linkedHashSet.remove(studentNumber);
			}
			linkedHashSet.add(studentNumber);
		}

		int count = 1;
		for(String studentNumber : linkedHashSet) {

			sb.append(studentNumber).append("\n");

			if(count == K) {
				break;
			}

			count++;
		}

		System.out.println(sb);
	}
}
