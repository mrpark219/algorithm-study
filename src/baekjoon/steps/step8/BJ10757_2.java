package baekjoon.steps.step8;

import java.util.Scanner;

public class BJ10757_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        int maxLength = A.length() > B.length() ? A.length() + 1 : B.length() + 1;
        int[] AArr = new int[maxLength];
        int[] BArr = new int[maxLength];
        int[] resultArr = new int[maxLength];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < A.length(); i++) {
            AArr[A.length() - 1 - i] = A.charAt(i) - '0';
        }
        for(int i = 0; i < B.length(); i++) {
            BArr[B.length() - 1 - i] = B.charAt(i) - '0';
        }

        for(int i = 0; i < maxLength; i++) {
            int result = AArr[i] + BArr[i];
            if(i != maxLength - 1) {
                AArr[i + 1] += result / 10;
            }
            resultArr[i] += result % 10;
        }

        if(resultArr[maxLength - 1] != 0) {
            sb.append(resultArr[maxLength - 1]);
        }
        for(int i = maxLength - 2; i >= 0; i--) {
            sb.append(resultArr[i]);
        }

        System.out.print(sb);

        sc.close();

    }
}
