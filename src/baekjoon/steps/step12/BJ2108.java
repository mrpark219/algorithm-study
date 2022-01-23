package baekjoon.steps.step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2108 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int sum = 0;
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[i] = input;
            sum += input;
        }

        Arrays.sort(arr);

        int mostCnt = 0;
        int mostValue = -4001;
        boolean secondMostFlag = false;

        for(int i = 0; i < N; ) {
            int sameCnt = 1;

            for(int j = i + 1; j < N; j++) {
                if(arr[i] != arr[j]) {
                    break;
                }
                sameCnt++;
            }

            if(sameCnt > mostCnt) {
                mostCnt = sameCnt;
                mostValue = arr[i];
                secondMostFlag = true;
            }
            else if(sameCnt == mostCnt && secondMostFlag) {
                mostValue = arr[i];
                secondMostFlag = false;
            }
            i += sameCnt;
        }

        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(mostValue);
        System.out.println(arr[N - 1] - arr[0]);

        br.close();
    }
}
