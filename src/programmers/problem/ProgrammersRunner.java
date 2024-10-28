package programmers.problem;

public class ProgrammersRunner {

	public static void main(String[] args) {

		String video_len = "34:33";
		String pos = "13:00";
		String op_start = "00:55";
		String op_end = "02:55";
		String[] commands = {"next", "prev"};

		System.out.println(new P340213.Solution().solution(video_len, pos, op_start, op_end, commands));
	}
}
