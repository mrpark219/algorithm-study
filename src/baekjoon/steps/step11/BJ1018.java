package baekjoon.steps.step11;

import java.util.Scanner;

public class BJ1018 {

    public static char[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            String input = sc.next();

            for(int j = 0; j < M; j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        int min = 64;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {

                int result = check(i, j);
                if(result < min) {
                    min = result;
                }
            }
        }

        System.out.println(min);

        sc.close();

    }

    public static int check(int x, int y) {

        int cnt = 0;
        char c = arr[x][y];

        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(arr[x + i][y + j] != c) {
                    cnt++;
                }

                if(c == 'W') {
                    c = 'B';
                }
                else {
                    c = 'W';
                }
            }

            if(c == 'W') {
                c = 'B';
            }
            else {
                c = 'W';
            }
        }

        cnt = Math.min(cnt, 64 - cnt);

        return cnt;
    }
}
