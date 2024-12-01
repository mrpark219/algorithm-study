package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ25206 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = new String[20];
		double totalSum = 0;
		double scoreSum = 0;
		Map<String, Double> gradeMap = new HashMap<>();
		gradeMap.put("A+", 4.5);
		gradeMap.put("A0", 4.0);
		gradeMap.put("B+", 3.5);
		gradeMap.put("B0", 3.0);
		gradeMap.put("C+", 2.5);
		gradeMap.put("C0", 2.0);
		gradeMap.put("D+", 1.5);
		gradeMap.put("D0", 1.0);
		gradeMap.put("F", 0.0);
		gradeMap.put("P", 0.0);

		for(int i = 0; i < 20; i++) {
			input[i] = br.readLine();
			StringTokenizer st = new StringTokenizer(input[i], " ");
			st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			Double gradePoint = gradeMap.get(grade);
			totalSum += score * gradePoint;
			if(!grade.equals("P")) {
				scoreSum += score;
			}
		}

		double average = totalSum / scoreSum;
		System.out.printf("%.6f\n", average);
	}
}
