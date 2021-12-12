package baekjoon.steps.step7;

import java.util.Arrays;
import java.util.Scanner;

public class BJ10809 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        String S = sc.next();

        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if(arr[c - 'a'] == -1) {
                arr[c - 'a'] = i;
            }
        }

        for(int n : arr) {
            System.out.print(n + " ");
        }

        sc.close();

    }
}
