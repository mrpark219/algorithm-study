package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ9461 {

    public static Long[] dp = new Long[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        dp[0] = 0L;
        dp[1] = 1L;
        dp[2] = 1L;
        dp[3] = 1L;

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(padovan(N));
        }

        br.close();

    }

    public static long padovan(int N) {

        if(dp[N] == null) {
            dp[N] = padovan(N - 2) + padovan(N - 3);
        }

        return dp[N];
    }

}
