package baekjoon.steps.step1;

import java.util.Scanner;

public class BJ2588 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int B100 = B / 100;
        int B10 = (B  % 100) / 10;
        int B1 = (B % 10);

        int step1 = A * B1;
        int step2 = A * B10;
        int step3 = A * B100;

        System.out.println(step1);
        System.out.println(step2);
        System.out.println(step3);

        System.out.println(step1 + step2 * 10 + step3 * 100);

        sc.close();
    }
}
