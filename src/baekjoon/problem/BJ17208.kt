package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader();

    var st = StringTokenizer(br.readLine())

    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    // dp[i][j] 치즈버거 i개와 감자튀김 j개를 사용했을 때 처리할 수 있는 최대 주문 개수
    val dp = Array(m + 1) { IntArray(k + 1) { 0 } }

    dp[0][0] = 0

    for(t in 0 until n) {
        st = StringTokenizer(br.readLine())

        val burger = st.nextToken().toInt()
        val cola = st.nextToken().toInt()

        if(burger > m || cola > k) {
            continue
        }

        for(i in m downTo burger) {
            for(j in k downTo cola) {
                dp[i][j] = dp[i][j].coerceAtLeast(dp[i - burger][j - cola] + 1)
            }
        }
    }

    write("${dp[m][k]}")

    close()
}