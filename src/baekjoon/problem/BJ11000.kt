package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    val classes = Array(n) { Pair(0, 0) }

    repeat(n) { it ->
        val (s, t) = br.readLine().split(" ").map { i -> i.toInt() }
        classes[it] = Pair(s, t)
    }

    classes.sortWith { o1, o2 ->
        if(o1.first == o2.first) {
            o1.second - o2.second
        }
        else {
            o1.first - o2.first
        }
    }

    val queue = PriorityQueue<Int>()

    queue.add(classes[0].second)

    for(i in 1 until n) {

        if(queue.peek() <= classes[i].first) {
            queue.poll()
        }
        queue.add(classes[i].second)
    }

    write("${queue.size}\n")
    close()
}
