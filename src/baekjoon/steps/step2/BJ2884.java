package baekjoon.steps.step2;

import java.util.Scanner;

public class BJ2884 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();

        if(M < 45) {
            if(H == 0) {
                H = 24;
            }
            H--;
            M = M + 60 - 45;
        }
        else {
            M -= 45;
        }

        System.out.println(H + " " + M);

        sc.close();
    }
}
