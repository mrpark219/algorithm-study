package baekjoon.steps.step4;

import java.util.Scanner;

public class BJ1110 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0, temp = N;

        do {
            cnt++;
            int N10, N1, newN1;
            if(temp < 10) {
                N10 = 0;
                N1 = temp;
            }
            else {
                N10 = temp / 10;
                N1 = temp % 10;
            }
            int newN = N10 + N1;
            if(newN < 10) {
                newN1 = newN;
            }
            else {
                newN1 = newN % 10;
            }
            temp = N1 * 10 + newN1;
        } while(N != temp);

        System.out.println(cnt);

        sc.close();

    }
}
