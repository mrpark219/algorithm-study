package baekjoon.problem

import kotlin.math.abs
import kotlin.math.sqrt

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (a, b) = br.readLine().split(" ").map { it.toLong() }
    var count = 0L

    for(i in sqrt(a.toDouble()).toLong()..sqrt(b.toDouble()).toLong()) {
        if(i * i > a) {
            count++
        }
    }

    if(count == 0L) {
        write("0")
        close()
        return@with
    }

    val mod = gcd(count, (b - a))

    write("${(count / mod)}/${((b - a) / mod)}")
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