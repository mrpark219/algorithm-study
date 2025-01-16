package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ4781 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while(true) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			double m = Double.parseDouble(st.nextToken());

			if(n == 0 && m == 0) {
				break;
			}

			int intM = (int) (m * 100 + 0.5);
			int[] calorieArray = new int[n];
			int[] priceArray = new int[n];

			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				calorieArray[i] = Integer.parseInt(st.nextToken());
				priceArray[i] = (int) (Double.parseDouble(st.nextToken()) * 100 + 0.5);
			}

			// 가격 당 최대 칼로리
			int[] dp = new int[intM + 1];
			dp[0] = 0;

			for(int i = 0; i < n; i++) {
				int calorie = calorieArray[i];
				int price = priceArray[i];

				for(int j = price; j <= intM; j++) {
					dp[j] = Math.max(dp[j], dp[j - price] + calorie);
				}
			}

			sb.append(dp[intM]).append("\n");
		}

		System.out.println(sb);
	}
}
