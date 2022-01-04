package baekjoon.steps.step9;

import java.util.Scanner;

public class BJ9020 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean[] primeArr = new boolean[10001];

        primeArr[0] = true;
        primeArr[1] = true;

        for(int i = 2; i <= Math.sqrt(primeArr.length); i++) {
            for(int j = i * i; j < primeArr.length; j += i) {
                primeArr[j] = true;
            }
        }

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int input = sc.nextInt();

            int front = input / 2;
            int back = input / 2;

            while(true) {
                if(!primeArr[front] && !primeArr[back]) {
                    System.out.println(front + " " + back);
                    break;
                }
                front--;
                back++;
            }
        }

        sc.close();

    }
}
