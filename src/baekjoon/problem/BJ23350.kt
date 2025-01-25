package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val mCount = IntArray(m + 1)
    val containers = Array(m + 1) { mutableListOf<Int>() }
    val railQueue: Queue<Pair<Int, Int>> = LinkedList()

    for(i in 0 until n) {
        val (p, w) = br.readLine().split(" ").map { it.toInt() }
        railQueue.add(p to w)
        mCount[p]++
    }

    var lowest = m
    var result = 0

    while(railQueue.isNotEmpty()) {

        val (p, w) = railQueue.poll()

        if(p != lowest) {
            result += w
            railQueue.add(p to w)
        }
        else {
            result += w
            mCount[lowest]--

            if(mCount[lowest] == 0) {
                lowest--
            }

            if(containers[p].isEmpty()) {
                containers[p].add(w)
            }
            else {
                for(i in containers[p]) {
                    if(i < w) {
                        result += 2 * i
                    }
                    else {
                        break
                    }
                }

                containers[p].add(w)
                containers[p].sort()
            }
        }
    }

    write("$result")
    close()
}