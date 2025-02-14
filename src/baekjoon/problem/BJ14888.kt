package baekjoon.problem

import kotlin.math.max
import kotlin.math.min

var minValue = Int.MAX_VALUE
var maxValue = Int.MIN_VALUE

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }
    val operatorList = br.readLine().split(" ").map { it.toInt() }.toMutableList()

    dfs(1, numbers[0], numbers, operatorList)

    write("$maxValue\n")
    write("$minValue")
    close()
}

private fun dfs(index: Int, value: Int, numbers: List<Int>, operatorList: MutableList<Int>) {

    if(index == numbers.size) {
        maxValue = max(maxValue, value)
        minValue = min(minValue, value)
        return
    }

    for(i in operatorList.indices) {

        if(operatorList[i] < 1) {
            continue
        }

        var v = value

        when(i) {
            // 더하기
            0 -> {
                v += numbers[index]
            }
            // 빼기
            1 -> {
                v -= numbers[index]
            }
            // 곱하기
            2 -> {
                v *= numbers[index]
            }
            // 나누기
            else -> {
                v = divide(v, numbers[index])
            }
        }

        operatorList[i]--
        dfs(index + 1, v, numbers, operatorList)
        operatorList[i]++
    }
}

private fun divide(a: Int, b: Int): Int {

    return if(a < 0) {
        ((a * -1) / b) * -1
    }
    else {
        a / b
    }
}