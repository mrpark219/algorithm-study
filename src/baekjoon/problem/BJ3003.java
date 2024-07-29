package baekjoon.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ3003 {

	private static final int KING_AMOUNT = 1;

	private static final int QUEEN_AMOUNT = 1;

	private static final int ROOK_AMOUNT = 2;

	private static final int BISHOP_AMOUNT = 2;

	private static final int KNIGHT_AMOUNT = 2;

	private static final int PAWN_AMOUNT = 8;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int king = Integer.parseInt(st.nextToken());
		int queen = Integer.parseInt(st.nextToken());
		int rook = Integer.parseInt(st.nextToken());
		int bishop = Integer.parseInt(st.nextToken());
		int knight = Integer.parseInt(st.nextToken());
		int pawn = Integer.parseInt(st.nextToken());

		sb.append(KING_AMOUNT - king);
		sb.append(" ");
		sb.append(QUEEN_AMOUNT - queen);
		sb.append(" ");
		sb.append(ROOK_AMOUNT - rook);
		sb.append(" ");
		sb.append(BISHOP_AMOUNT - bishop);
		sb.append(" ");
		sb.append(KNIGHT_AMOUNT - knight);
		sb.append(" ");
		sb.append(PAWN_AMOUNT - pawn);

		System.out.println(sb);
	}
}
