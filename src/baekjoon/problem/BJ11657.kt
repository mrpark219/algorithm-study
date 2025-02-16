package baekjoon.problem

private var n = 0
private var m = 0
private const val INF = 10000L * 6000 * 500 * 10
lateinit var distance: LongArray
lateinit var edges: Array<IntArray>

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (tempN, tempM) = br.readLine().split(" ").map { it.toInt() }
    n = tempN
    m = tempM
    distance = LongArray(n + 1) { INF }
    edges = Array(m) { IntArray(3) }

    for(i in 0 until m) {
        val (start, end, cost) = br.readLine().split(" ").map { it.toInt() }
        edges[i][0] = start
        edges[i][1] = end
        edges[i][2] = cost
    }

    val result = bellmanFord(1)

    if(result) {
        write("-1\n")
    }
    else {
        for(i in 2..n) {
            if(distance[i] == INF) {
                write("-1\n")
            }
            else {
                write("${distance[i]}\n")
            }
        }
    }
    close()
}

private fun bellmanFord(startIndex: Int): Boolean {

    distance[startIndex] = 0

    for(i in 1 until n) {
        for(edge in edges) {
            val start = edge[0]
            val end = edge[1]
            val cost = edge[2]
            if(distance[start] != INF) {
                if(distance[end] > distance[start] + cost) {
                    distance[end] = distance[start] + cost
                }
            }
        }
    }

    // 음수 가중치 순환 확인
    for(edge in edges) {
        val start = edge[0]
        val end = edge[1]
        val cost = edge[2]
        if(distance[start] != INF && distance[end] > distance[start] + cost) {
            return true
        }
    }

    return false
}