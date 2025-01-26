package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val queue = LinkedList<Int>()

    for(i in 1..n) {
        queue.add(i)
    }

    write("<")

    while(queue.size > 1) {

        for(i in 0 until k - 1) {
            queue.offer(queue.poll())
        }

        write("${queue.poll()}, ")
    }

    write("${queue.poll()}>")
    close()
}