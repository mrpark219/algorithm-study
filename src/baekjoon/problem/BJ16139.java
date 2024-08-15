package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ16139 {

	public static Map<String, int[]> sumMap = new HashMap<>();
	public static String S;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();


		S = br.readLine();
		int q = Integer.parseInt(br.readLine());

		for(int i = 1; i <= q; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String a = st.nextToken();
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			if(!sumMap.containsKey(a)) {
				solution(a);
			}

			int[] sumArray = sumMap.get(a);

			if(l != 0) {
				sb.append(sumArray[r] - sumArray[l - 1]).append("\n");
			}
			else {
				sb.append(sumArray[r]).append("\n");
			}
		}

		System.out.println(sb);
	}

	public static void solution(String a) {
		int[] sumArray = new int[S.length()];

		for(int i = 0; i < S.length(); i++) {
			int previousCount;
			if(i == 0) {
				previousCount = 0;
			}
			else {
				previousCount = sumArray[i - 1];
			}

			if(a.equals(String.valueOf(S.charAt(i)))) {
				sumArray[i] += previousCount + 1;
			}
			else {
				sumArray[i] = previousCount;
			}
		}

		sumMap.put(a, sumArray);
	}
}
