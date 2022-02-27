package baekjoon.steps.step15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1463 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(make1(N, 0));

        br.close();

    }

    public static int make1(int N, int cnt) {

        if(N < 2) {
            return cnt;
        }

        return Math.min(make1(N / 2, cnt + 1 + N % 2), make1(N / 3, cnt + 1 + N % 3));

    }
}
