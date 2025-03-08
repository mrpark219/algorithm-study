package programmers.problem

import java.util.*

class P389479 {
    fun solution(players: IntArray, m: Int, k: Int): Int {

        var count = 0
        val queue = LinkedList<Int>()

        for(i in 0..23) {
            val player = players[i]

            if(player >= m) {
                val minServer = player / m

                if(minServer > queue.size) {
                    val plusServer = minServer - queue.size

                    count += plusServer
                    for(j in 0 until plusServer) {
                        queue.add(i + k)
                    }
                }
            }

            if(queue.isNotEmpty()) {
                while(queue.peek() == i + 1) {
                    queue.poll()
                }
            }
        }

        return count
    }
}

fun main() {

    val players = intArrayOf(0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5)
    val m = 3
    val k = 5

    println(P389479().solution(players, m, k))
}
