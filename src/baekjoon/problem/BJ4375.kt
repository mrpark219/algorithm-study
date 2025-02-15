package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    while(true) {
        val input = br.readLine() ?: break
        val result = solution(input)
        write("$result\n")
    }

    close()
}

private fun solution(input: String): Int {

    var result = 1
    var num = 1
    var modSum = 0

    while(true) {
        val mod = num % input.toInt()
        modSum += mod

        if(modSum % input.toInt() == 0) {
            break
        }

        result++
        num = mod * 10
    }

    return result
}