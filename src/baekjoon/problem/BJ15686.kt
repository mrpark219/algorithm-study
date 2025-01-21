package baekjoon.problem

import java.util.*
import kotlin.math.abs

private var min = Integer.MAX_VALUE
private lateinit var visited: BooleanArray
private lateinit var chickenDistanceArray: Array<IntArray>

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val homeList = mutableListOf<IntArray>()
    val chickenList = mutableListOf<IntArray>()

    for(i in 0 until n) {
        val st = StringTokenizer(br.readLine())
        for(j in 0 until n) {
            val input = st.nextToken().toInt()

            if(input == 1) {
                homeList.add(intArrayOf(i, j))
            }
            else if(input == 2) {
                chickenList.add(intArrayOf(i, j))
            }
        }
    }

    // 치킨 거리 정보 계산 (치킨집과 집의 거리 저장)
    chickenDistanceArray = Array(chickenList.size) { IntArray(homeList.size) }

    for(i in 0 until chickenList.size) {
        val chickenR = chickenList[i][0]
        val chickenC = chickenList[i][1]
        for(j in 0 until homeList.size) {
            val homeR = homeList[j][0]
            val homeC = homeList[j][1]
            chickenDistanceArray[i][j] = abs(chickenR - homeR) + abs(chickenC - homeC)
        }
    }

    visited = BooleanArray(chickenList.size)

    dfs(0, -1, m, homeList.size)

    write("$min")
    close()
}

private fun dfs(count: Int, index: Int, m: Int, homeCount: Int) {
    if(count == m) {
        val distance = IntArray(homeCount) { Int.MAX_VALUE }

        for(i in visited.indices) {
            if(visited[i]) {
                for(j in 0 until homeCount) {
                    distance[j] = minOf(distance[j], chickenDistanceArray[i][j])
                }
            }
        }

        min = minOf(min, distance.sum())
        return
    }

    for(i in chickenDistanceArray.indices) {
        if(i >= index) {
            if(!visited[i]) {
                visited[i] = true
                dfs(count + 1, i + 1, m, homeCount)
                visited[i] = false
            }
        }
    }
}