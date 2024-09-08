package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ6487 {

	public static double a, b;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());

			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());

			double x3 = Double.parseDouble(st.nextToken());
			double y3 = Double.parseDouble(st.nextToken());

			double x4 = Double.parseDouble(st.nextToken());
			double y4 = Double.parseDouble(st.nextToken());

			boolean is1Horizontal = (y1 == y2);
			boolean is1Vertical = (x1 == x2);

			boolean is2Horizontal = (y3 == y4);
			boolean is2Vertical = (x3 == x4);

			if(is1Vertical) {
				if(is2Vertical) {
					if(x1 == x3) {
						sb.append("LINE");
					}
					else {
						sb.append("NONE");
					}
				}
				else if(is2Horizontal) {
					sb.append("POINT").append(" ").append(String.format("%.2f", x1)).append(" ").append(String.format("%.2f", y3));
				}
				else {
					calculate(x3, y3, x4, y4);
					double pointY = a * x1 + b;
					sb.append("POINT").append(" ").append(String.format("%.2f", x1)).append(" ").append(String.format("%.2f", pointY));
				}
			}
			else if(is1Horizontal) {
				if(is2Vertical) {
					sb.append("POINT").append(" ").append(String.format("%.2f", x3)).append(" ").append(String.format("%.2f", y1));
				}
				else if(is2Horizontal) {
					if(y1 == y3) {
						sb.append("LINE");
					}
					else {
						sb.append("NONE");
					}
				}
				else {
					calculate(x3, y3, x4, y4);
					double pointX = (y3 - b) / a;
					sb.append("POINT").append(" ").append(String.format("%.2f", pointX)).append(" ").append(String.format("%.2f", y3));
				}
			}
			else if(is2Vertical) {
				calculate(x1, y1, x2, y2);
				double pointY = a * x3 + b;
				sb.append("POINT").append(" ").append(String.format("%.2f", x3)).append(" ").append(String.format("%.2f", pointY));
			}
			else if(is2Horizontal) {
				calculate(x1, y1, x2, y2);
				double pointX = (y3 - b) / a;
				sb.append("POINT").append(" ").append(String.format("%.2f", pointX)).append(" ").append(String.format("%.2f", y3));
			}
			else {
				calculate(x1, y1, x2, y2);
				double a1 = a;
				double b1 = b;

				calculate(x3, y3, x4, y4);
				double a2 = a;
				double b2 = b;

				if(a1 == a2) {
					if(b1 == b2) {
						sb.append("LINE");
					}
					else {
						sb.append("NONE");
					}
				}
				else {

					double pointX = (b2 - b1) / (a1 - a2);
					double pointY = a1 * pointX + b1;

					sb.append("POINT").append(" ").append(String.format("%.2f", pointX)).append(" ").append(String.format("%.2f", pointY));
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

	public static void calculate(double x1, double y1, double x2, double y2) {
		a = (y2 - y1) / (x2 - x1);
		b = y1 - a * x1;
	}
}
