package baekjoon.steps.step7;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ1152 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine().trim();

        StringTokenizer st = new StringTokenizer(input, " ");

        System.out.println(st.countTokens());

        sc.close();

    }
}
