package baekjoon.problem;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ26069 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Set<String> enterUser = new HashSet<>();
		enterUser.add("ChongChong");

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String userA = st.nextToken();
			String userB = st.nextToken();

			if(enterUser.contains(userA) || enterUser.contains(userB)) {
				enterUser.add(userA);
				enterUser.add(userB);
			}
		}

		System.out.println(enterUser.size());
	}
}
