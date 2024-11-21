package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String[] split = input.split("-");

		int total = 0;

		for(int i = 0; i < split.length; i++) {
			int sum = 0;
			String[] numbers = split[i].split("\\+");
			for(String number : numbers) {
				sum += Integer.parseInt(number);
			}
			total = i == 0 ? total + sum : total - sum;
		}

		System.out.println(total);
	}
}
