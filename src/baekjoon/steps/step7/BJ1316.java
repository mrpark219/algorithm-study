package baekjoon.steps.step7;

import java.util.Scanner;

public class BJ1316 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int cnt = 0;

        for(int i = 0; i < N; i++) {

            String input = sc.next();

            if(checkStr(input)) {
                cnt++;
            }
        }

        System.out.println(cnt);

        sc.close();

    }

    public static boolean checkStr(String input) {

        boolean[] alpha = new boolean[26];
        char beforeChar = ' ';

        for(int i = 0; i < input.length(); i++) {
            char nowChar = input.charAt(i);

            if(alpha[nowChar - 'a']) {
                if(beforeChar != nowChar) {
                    return false;
                }
            }
            else {
                alpha[nowChar - 'a'] = true;
            }
            beforeChar = nowChar;

        }

        return true;
    }

}
