package baekjoon.steps.step8;

import java.util.Scanner;

public class BJ2775 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] arr = new int[15][15];

            for(int j = 1; j < 15; j++) {
                arr[0][j] = j;
            }

            for(int o = 1; o <= k; o++) {
                int floorCnt = 0;
                for(int p = 1; p <= n; p++) {
                    floorCnt += arr[o - 1][p];
                    arr[o][p] = floorCnt;
                }
            }

            System.out.println(arr[k][n]);
        }

        sc.close();

    }
}
