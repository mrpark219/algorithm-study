package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ10844 {

    public static Long[][] dp;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Long[N + 1][10];
        long cnt = 0;

        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1L;
        }

        for(int i = 1; i < 10; i++) {
            cnt += stair(N, i);
        }

        System.out.println(cnt % 1000000000);

        br.close();

    }

    public static long stair(int N, int value) {

        if(N == 1) {
            return dp[N][value];
        }

        if(dp[N][value] == null) {
            if(value == 0) {
                dp[N][value] = stair(N - 1, 1);
            }
            else if(value == 9) {
                dp[N][value] = stair(N - 1, 8);
            }
            else {
                dp[N][value] = stair(N - 1, value - 1) + stair(N - 1, value + 1);
            }
        }

        return dp[N][value] % 1000000000;
    }
}
