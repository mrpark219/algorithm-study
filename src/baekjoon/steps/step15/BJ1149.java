package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1149 {

    public static int min = Integer.MAX_VALUE;
    public static int N;
    public static int[][] arr;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        dp = new int[N][3];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        System.out.println(Math.min(rgb(N - 1, 0), Math.min(rgb(N - 1, 1), rgb(N - 1, 2))));

        br.close();

    }

    public static int rgb(int depth, int color) {

        if(dp[depth][color] == 0) {
            if(color == 0) {
                dp[depth][0] = Math.min(rgb(depth - 1, 1), rgb(depth - 1, 2)) + arr[depth][0];
            }
            else if(color == 1) {
                dp[depth][1] = Math.min(rgb(depth - 1, 0), rgb(depth - 1, 2)) + arr[depth][1];
            }
            else {
                dp[depth][2] = Math.min(rgb(depth - 1, 0), rgb(depth - 1, 1)) + arr[depth][2];
            }
        }

        return dp[depth][color];
    }
}
