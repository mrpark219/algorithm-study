package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val a = br.readLine().toDouble() / 100
    val b = br.readLine().toDouble() / 100

    // dp[index][a][b]: index 단계에서 점수가 a, b일 확률
    val dp = Array(19) { Array(19) { DoubleArray(19) { 0.0 } } }
    dp[0][0][0] = 1.0

    val primeList = listOf(2, 3, 5, 7, 11, 13, 17)

    for(i in 1..18) {
        for(j in 0..i) {
            for(k in 0..i) {
                if(j > 0) {
                    // a만 득점
                    dp[i][j][k] += dp[i - 1][j - 1][k] * a * (1 - b)
                }
                if(k > 0) {
                    // b만 득점
                    dp[i][j][k] += dp[i - 1][j][k - 1] * (1 - a) * b
                }
                if(j > 0 && k > 0) {
                    // 둘 다 득점
                    dp[i][j][k] += dp[i - 1][j - 1][k - 1] * a * b
                }
                // 둘 다 득점 실패
                dp[i][j][k] += dp[i - 1][j][k] * (1 - a) * (1 - b)
            }
        }
    }

    var result = 0.0
    for(i in 0..18) {
        for(j in 0..18) {
            if(i in primeList || j in primeList) {
                result += dp[18][i][j]
            }
        }
    }

    write("$result")
    close()
}