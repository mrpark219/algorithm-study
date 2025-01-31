package baekjoon.problem

import kotlin.math.abs

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    var m = 0L
    val aArray = LongArray(n + 1)
    val bArray = LongArray(n + 1)

    for(i in 1..n) {
        val (a, b) = br.readLine().split(" ").map { it.toLong() }

        aArray[i] = a
        bArray[i] = b
        m = gcd(m, bArray[i] - bArray[i - 1] - aArray[i])
    }

    for(i in 1..n) {
        // 입금이고, 모순이 없다면
        if(bArray[i] - bArray[i - 1] == aArray[i]) {
            continue
        }

        // 모순이 있다면
        // 모두 출금이여야 하는데 입금인 경우
        // m보다 남은 금액이 더 큰 경우
        // 출금이지만 잔액 범위 안에서 처리 가능한 경우
        if(aArray[i] > 0 || (m > 0 && m <= bArray[i]) || (abs(aArray[i]) < bArray[i - 1])) {
            write("-1")
            close()
            return
        }
    }

    // m == 0 이면 입금만 한 경우
    write("${if(m > 0) m else 1}")
    close()
}

private fun gcd(a: Long, b: Long): Long {
    var x = a
    var y = b
    while(y != 0L) {
        val temp = x % y
        x = y
        y = temp
    }
    return abs(x)
}