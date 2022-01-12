package baekjoon.steps.step10;

import java.util.Scanner;

public class BJ2447 {

    public static char[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = ' ';
            }
        }

        star(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

        sc.close();

    }

    public static void star(int x, int y, int n) {

        if(n == 1) {
            arr[x][y] = '*';
            return;
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!(i == 1 && j == 1)) {
                    star(x + (i * n / 3), y + (j * n / 3), n / 3);
                }
            }
        }

    }

}
