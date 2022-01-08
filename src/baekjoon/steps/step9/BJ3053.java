package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ3053 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double r = sc.nextDouble();

        System.out.println(Math.PI * r * r);
        System.out.println(2 * r * r);

        sc.close();

    }
}
