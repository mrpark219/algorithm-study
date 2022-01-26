package baekjoon.steps.step12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>(set);

        list.sort((o1, o2) -> {
            if(o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            else {
                return o1.length() - o2.length();
            }
        });

        StringBuilder sb = new StringBuilder();
        for(String s : list) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);

        br.close();

    }
}
