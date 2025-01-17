package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    var st = StringTokenizer(br.readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val H = st.nextToken().toInt()

    val blockArray = Array(N + 1) { Array(M) { 0 } }

    for(i in 1..N) {
        st = StringTokenizer(br.readLine())

        var index = 0
        while(st.hasMoreTokens()) {
            blockArray[i][index++] = st.nextToken().toInt()
        }
    }

    // N명의 학생이 index 높이를 만들 수 있는 경우의 수
    val dp = Array(N + 1) { IntArray(H + 1) }

    for(i in 1..N) {
        for(j in 1..H) {
            for(block in blockArray[i]) {

                // 0이 나오면 종료
                if(block == 0) {
                    break
                }

                // j 높이의 블록이 있다면 -> 1 증가
                if(j == block) {
                    dp[i][j]++
                }
                // 이전 학생이 j - block 높이를 만들 수 있는 경우의 수
                if(j > block) {
                    dp[i][j] += dp[i - 1][j - block]
                }
            }
            // 이전 학생이 j 높이까지 만들 수 있는 경우의 수
            dp[i][j] += dp[i - 1][j]
            dp[i][j] %= 10007
        }
    }

    write("${dp[N][H]}")

    close()
}