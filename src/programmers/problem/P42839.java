package programmers.problem;

import java.util.HashSet;
import java.util.Set;

public class P42839 {

	static class Solution {

		Set<Integer> primeSet = new HashSet<>();
		int[] numArray = new int[10];

		public int solution(String numbers) {

			for(int i = 0; i < numbers.length(); i++) {
				numArray[numbers.charAt(i) - '0']++;
			}

			search(0, numbers.length(), "");

			return primeSet.size();
		}

		public void search(int count, int length, String current) {

			if(count > 0) {
				int n = Integer.parseInt(current);
				if(isPrime(n)) {
					primeSet.add(n);
				}
			}

			if(count == length) {
				return;
			}

			for(int i = 0; i < 10; i++) {
				if(numArray[i] > 0) {
					numArray[i]--;
					search(count + 1, length, current + i);
					numArray[i]++;
				}
			}
		}

		public boolean isPrime(int n) {
			if(n < 2) {
				return false;
			}
			if(n == 2) {
				return true;
			}
			if(n % 2 == 0) {
				return false;
			}

			for(int i = 3; i * i <= n; i += 2) {
				if(n % i == 0) {
					return false;
				}
			}

			return true;
		}
	}
}
