package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1932 {

    public static int[][] arr;
    public static Integer[][] dp;
    public static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        dp = new Integer[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            dp[n - 1][i] = arr[n - 1][i];
        }

        System.out.println(triangle(0, 0));

        br.close();

    }

    public static int triangle(int depth, int index) {

        if(depth == n - 1) {
            return dp[depth][index];
        }

        if(dp[depth][index] == null) {
            dp[depth][index] = Math.max(triangle(depth + 1, index), triangle(depth + 1, index + 1)) + arr[depth][index];
        }

        return dp[depth][index];
    }
}
