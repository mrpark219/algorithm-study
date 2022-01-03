package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ1929 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        boolean[] primeArr = new boolean[N + 1];

        primeArr[0] = true;
        primeArr[1] = true;

        for(int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            for(int j = i * i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }

        for(int i = M; i <= N; i++) {
            if(!primeArr[i]) {
                System.out.println(i);
            }
        }

        sc.close();

    }
}
