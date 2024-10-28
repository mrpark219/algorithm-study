package programmers.problem;

import java.util.StringTokenizer;

public class P340213 {

	static class Solution {
		public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

			StringTokenizer st = new StringTokenizer(video_len, ":");
			int video_len_mm = Integer.parseInt(st.nextToken());
			int video_len_ss = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(op_start, ":");
			int op_start_mm = Integer.parseInt(st.nextToken());
			int op_start_ss = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(op_end, ":");
			int op_end_mm = Integer.parseInt(st.nextToken());
			int op_end_ss = Integer.parseInt(st.nextToken());

			for(String command : commands) {

				st = new StringTokenizer(pos, ":");
				int mm = Integer.parseInt(st.nextToken());
				int ss = Integer.parseInt(st.nextToken());

				boolean after_op_start = ((mm > op_start_mm) || (mm >= op_start_mm && ss >= op_start_ss));
				boolean before_op_end = ((mm < op_end_mm) || mm <= op_end_mm && ss <= op_end_ss);

				if(after_op_start && before_op_end) {
					mm = op_end_mm;
					ss = op_end_ss;
				}

				if(command.equals("prev")) {
					ss -= 10;
					if(ss < 0) {
						mm--;
						ss = 60 + ss;
					}
					if((mm < 0) || (mm <= 0 && ss <= 0)) {
						pos = "00:00";
						continue;
					}
				}
				else if(command.equals("next")) {
					ss += 10;
					if(ss >= 60) {
						mm++;
						ss -= 60;
					}

					if((mm > video_len_mm) || (mm >= video_len_mm && ss >= video_len_ss)) {
						pos = video_len;
						continue;
					}
				}

				pos = String.format("%02d:%02d", mm, ss);
			}

			st = new StringTokenizer(pos, ":");
			int mm = Integer.parseInt(st.nextToken());
			int ss = Integer.parseInt(st.nextToken());

			boolean after_op_start = ((mm > op_start_mm) || (mm >= op_start_mm && ss >= op_start_ss));
			boolean before_op_end = ((mm < op_end_mm) || mm <= op_end_mm && ss <= op_end_ss);

			if(after_op_start && before_op_end) {
				pos = op_end;
			}

			return pos;
		}
	}
}
