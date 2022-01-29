package baekjoon.steps.step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] originArr = new int[N];
        int[] sortArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            originArr[i] = sortArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sortArr);

        int rank = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : sortArr) {
            if(!map.containsKey(n)) {
                map.put(n, rank);
                rank++;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int n : originArr) {
            sb.append(map.get(n)).append(" ");
        }

        System.out.println(sb);

        br.close();

    }
}
