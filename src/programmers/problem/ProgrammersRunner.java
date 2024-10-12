package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = new int[]{7,4,5,6};

		System.out.println(new P42583.Solution().solution(bridge_length, weight, truck_weights));
	}
}
