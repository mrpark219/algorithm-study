package programmers.problem

import kotlin.math.min

class P389480 {

    fun solution(info: Array<IntArray>, n: Int, m: Int): Int {

        // dp[i][b]
        // 물건을 훔친 개수가 i개이고,
        // B 도둑의 흔적 개수가 b개 일 때
        // A 도둑의 최소 흔적 개수
        val dp = Array(info.size + 1) { IntArray(m) { 40 * 120 } }
        dp[0][0] = 0

        for(i in 1..info.size) {
            val a = info[i - 1][0]
            val b = info[i - 1][1]

            for(j in 0 until m) {

                dp[i][j] = min(dp[i][j], dp[i - 1][j] + a)

                if(j + b < m) {
                    dp[i][j + b] = min(dp[i][j + b], dp[i - 1][j])
                }
            }
        }

        var minA = Int.MAX_VALUE
        for(i in 0 until m) {
            minA = min(minA, dp[info.size][i])
        }

        return if(minA < n) minA else -1
    }
}

fun main() {

    val info = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(2, 3),
        intArrayOf(2, 1)
    )
    val n = 4
    val m = 4

    println(P389480().solution(info, n, m))
}