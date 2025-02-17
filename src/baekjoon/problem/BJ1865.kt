package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val tc = br.readLine().toInt()

    repeat(tc) {

        val (n, m, w) = br.readLine().split(" ").map { it.toInt() }

        val edges = mutableListOf<Triple<Int, Int, Int>>()

        repeat(m) {
            val (start, end, time) = br.readLine().split(" ").map { it.toInt() }
            edges.add(Triple(start, end, time))
            edges.add(Triple(end, start, time))
        }

        repeat(w) {
            val (start, end, time) = br.readLine().split(" ").map { it.toInt() }
            edges.add(Triple(start, end, time * -1))
        }

        if(bellmanFord(n, edges)) {
            write("YES\n")
        }
        else {
            write("NO\n")
        }
    }

    close()
}

private fun bellmanFord(n: Int, edges: MutableList<Triple<Int, Int, Int>>): Boolean {

    val INF = 500L * 2500 * 200 * 10
    val distance = LongArray(n + 1) { INF }

    distance[1] = 0

    for(i in 1 until n) {
        for(edge in edges) {
            val (start, end, time) = edge

            if(distance[end] > distance[start] + time) {
                distance[end] = distance[start] + time
            }
        }
    }

    for(edge in edges) {
        val (start, end, time) = edge
        if(distance[end] != INF && distance[end] > distance[start] + time) {
            return true
        }
    }

    return false
}