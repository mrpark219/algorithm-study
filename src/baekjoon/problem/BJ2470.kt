package baekjoon.problem

import kotlin.math.abs

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val solutions = br.readLine().split(" ").map { it.toInt() }.sorted()

    // 다 양수
    if(solutions[0] > 0) {
        write("${solutions[0]} ${solutions[1]}")
    }
    // 다 음수
    else if(solutions[n - 1] < 0) {
        write("${solutions[n - 2]} ${solutions[n - 1]}")
    }
    // 섞인 경우
    else {
        var start = 0
        var end = n - 1
        var minAbs = Int.MAX_VALUE
        var pair = Pair(solutions[start], solutions[end])

        while(start < end) {
            val sum = solutions[start] + solutions[end]
            val currentAbs = abs(sum)

            if(currentAbs < minAbs) {
                minAbs = currentAbs
                pair = Pair(solutions[start], solutions[end])
            }

            if(sum > 0) {
                end--
            }
            else {
                start++
            }
        }

        write("${pair.first} ${pair.second}")
    }
    close()
}
