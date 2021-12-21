package baekjoon.steps.step8;

import java.util.Scanner;

public class BJ2292 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 1;
        int num = 1;

        while(N > num) {
            num += 6 * cnt;
            cnt++;
        }

        System.out.println(cnt);

        sc.close();

    }
}
