package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@SuppressWarnings("ALL")
public class BJ30801 {

	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String lv = br.readLine();
		String input = br.readLine();

		int lvPosition = 0;
		int inputPosition = 0;
		int level = 0;
		ArrayList<String> stringList = new ArrayList<>();

		// 첫 줄 입력 처리
		while(lv.length() > lvPosition) {

			String lvString;
			char c = lv.charAt(lvPosition);
			if(c == 'W' || c == 'A' || c == 'S' || c == 'D') {
				lvString = String.valueOf(c);
			}
			else {
				lvPosition++;
				char nextC = lv.charAt(lvPosition);
				lvString = String.valueOf(c) + String.valueOf(nextC);
			}
			lvPosition++;

			if(lv.length() > lvPosition && lv.charAt(lvPosition) == '!') {
				lvPosition++;

				if(lvString.equals("W")) {
					lvString = "S";
				}
				else if(lvString.equals("A")) {
					lvString = "D";
				}
				else if(lvString.equals("S")) {
					lvString = "W";
				}
				else if(lvString.equals("D")) {
					lvString = "A";
				}
				else if(lvString.equals("LU")) {
					lvString = "RD";
				}
				else if(lvString.equals("LD")) {
					lvString = "RU";
				}
				else if(lvString.equals("RU")) {
					lvString = "LD";
				}
				else if(lvString.equals("RD")) {
					lvString = "LU";
				}
			}
			stringList.add(lvString);
			level++;
		}

		lvPosition = 0;
		while(input.length() > inputPosition) {

			char c1 = input.charAt(inputPosition++);

			if(level == lvPosition) {
				lvPosition = 0;
				continue;
			}

			String lvString = stringList.get(lvPosition);

			if(lvString.equals("W") && (c1 == 'W' || c1 == '8')) {
				lvPosition++;
			}
			else if(lvString.equals("A") && (c1 == 'A' || c1 == '4')) {
				lvPosition++;
			}
			else if(lvString.equals("S") && (c1 == 'S' || c1 == '2')) {
				lvPosition++;
			}
			else if(lvString.equals("D") && (c1 == 'D' || c1 == '6')) {
				lvPosition++;
			}
			else if(lvString.equals("LU") && c1 == '7') {
				lvPosition++;
			}
			else if(lvString.equals("LD") && c1 == '1') {
				lvPosition++;
			}
			else if(lvString.equals("RU") && c1 == '9') {
				lvPosition++;
			}
			else if(lvString.equals("RD") && c1 == '3') {
				lvPosition++;
			}
			else {
				lvPosition = 0;
			}
		}

		if(level == lvPosition) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		br.close();
	}
}
