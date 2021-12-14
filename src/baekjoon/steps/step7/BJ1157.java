package baekjoon.steps.step7;

import java.util.Scanner;

public class BJ1157 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.next();
        int[] arr = new int[26];

        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(c >= 'A' && c <= 'Z') {
                arr[c - 'A']++;
            }
            else {
                arr[c - 'a']++;
            }

        }

        int maxCnt = -1;
        char maxChar = '?';

        for(int i = 0; i < 26; i++) {
            if(arr[i] > maxCnt) {
                maxCnt = arr[i];
                maxChar = (char) (i + 65);
            }
            else if(arr[i] == maxCnt) {
                maxChar = '?';
            }
        }
        System.out.println(maxChar);

        sc.close();

    }
}
