package programmers.problem

import kotlin.math.max

lateinit var connectionInfo: Array<MutableList<Int>>
var maxSheepCount = 0

private fun solution(info: IntArray, edges: Array<IntArray>): Int {

    connectionInfo = Array(info.size) { mutableListOf() }

    for(edge in edges) {
        connectionInfo[edge[0]].add(edge[1])
    }

    dfs(0, 0, 0, mutableListOf(0), info)

    return maxSheepCount
}

private fun dfs(index: Int, sheepCount: Int, wolfCount: Int, nextList: MutableList<Int>, info: IntArray) {

    var sheep = sheepCount
    var wolf = wolfCount

    if(info[index] == 0) {
        sheep++
    }
    else {
        wolf++
    }

    if(wolf >= sheep) {
        return
    }

    maxSheepCount = max(maxSheepCount, sheep)

    val next = mutableListOf<Int>()
    next.addAll(nextList)
    next.remove(index)

    for(i in connectionInfo[index]) {
        next.add(i)
    }

    for(i in next) {
        dfs(i, sheep, wolf, next, info)
    }
}

fun main() {

    val info = intArrayOf(0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1)
    val edges = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(1, 4),
        intArrayOf(0, 8),
        intArrayOf(8, 7),
        intArrayOf(9, 10),
        intArrayOf(9, 11),
        intArrayOf(4, 3),
        intArrayOf(6, 5),
        intArrayOf(4, 6),
        intArrayOf(8, 9)
    )

    println(solution(info, edges))
}