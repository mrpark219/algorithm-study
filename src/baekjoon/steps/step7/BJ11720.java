package baekjoon.steps.step7;

import java.util.Scanner;

public class BJ11720 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String input = sc.next();
        int sum = 0;

        for(int i = 0; i < N; i++) {
            sum += input.charAt(i) - '0';
        }

        System.out.println(sum);

        sc.close();

    }
}
