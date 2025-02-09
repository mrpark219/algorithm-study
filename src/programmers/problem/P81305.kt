package programmers.problem

import kotlin.math.max
import kotlin.math.min

private fun solution(k: Int, num: IntArray, links: Array<IntArray>): Int {

    val nodes = Array(num.size) { Node(links[it][0], links[it][1]) }
    val parent = IntArray(num.size) { -1 }
    var size = 0
    var root = -1

    for(i in num.indices) {
        if(nodes[i].left != -1) {
            parent[nodes[i].left] = i
        }
        if(nodes[i].right != -1) {
            parent[nodes[i].right] = i
        }
    }

    for(i in parent.indices) {
        if(parent[i] == -1) {
            root = i
            break
        }
    }

    fun dfs(current: Int, max: Int): Int {
        var leftCount = 0
        var rightCount = 0

        if(nodes[current].left != -1) {
            leftCount = dfs(nodes[current].left, max)
        }
        if(nodes[current].right != -1) {
            rightCount = dfs(nodes[current].right, max)
        }

        if(num[current] + leftCount + rightCount <= max) {
            return num[current] + leftCount + rightCount
        }

        if(num[current] + min(leftCount, rightCount) <= max) {
            size++
            return num[current] + min(leftCount, rightCount)
        }

        size += 2
        return num[current]
    }

    fun checkGroup(max: Int): Int {
        size = 0
        dfs(root, max)
        return size + 1
    }

    var start = 0
    var end = 10000 * 10000
    for(n in num) {
        start = max(start, n)
    }

    while(start <= end) {
        val mid = (start + end) / 2
        if(checkGroup(mid) <= k) {
            end = mid - 1
        }
        else {
            start = mid + 1
        }
    }

    return end + 1
}

private data class Node(val left: Int, val right: Int)

fun main() {

    val k = 4
    val num = intArrayOf(6, 9, 7, 5)
    val links = arrayOf(
        intArrayOf(-1, -1),
        intArrayOf(-1, -1),
        intArrayOf(-1, 0),
        intArrayOf(2, 1)
    )

    println(solution(k, num, links))
}