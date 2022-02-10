package baekjoon.steps.step14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580 {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        func(0, 0);
    }

    public static void func(int row, int col) {

        if(col == 9) {
            func(row + 1, 0);
            return;
        }

        if(row == 9) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            System.exit(0);
        }

        if(arr[row][col] == 0) {
            for(int i = 1; i < 10; i++) {
                if(check(row, col, i)) {
                    arr[row][col] = i;
                    func(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        func(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {
        //행 체크
        for(int i = 0; i < 9; i++) {
            if(arr[row][i] == value) {
                return false;
            }
        }

        //열 체크
        for(int i = 0; i < 9; i++) {
            if(arr[i][col] == value) {
                return false;
            }
        }

        //칸 체크
        int grid_row = (row / 3) * 3;
        int grid_col = (col / 3) * 3;

        for(int i = grid_row; i < grid_row + 3; i++) {
            for(int j = grid_col; j < grid_col + 3; j++) {
                if(arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }
}
