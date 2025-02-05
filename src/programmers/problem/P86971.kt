package programmers.problem

import kotlin.math.abs
import kotlin.math.min

private fun find(parent: IntArray, x: Int): Int {
    if(parent[x] == x) {
        return x
    }
    parent[x] = find(parent, parent[x])
    return parent[x]
}

private fun union(parent: IntArray, a: Int, b: Int) {
    val rootA = find(parent, a)
    val rootB = find(parent, b)
    if(rootA != rootB) {
        parent[rootB] = rootA
    }
}

private fun solution(n: Int, wires: Array<IntArray>): Int {
    var minAbs = n

    for(t in wires.indices) {
        val parent = IntArray(n + 1) { it }

        for(i in wires.indices) {
            if(i == t) {
                continue
            }
            union(parent, wires[i][0], wires[i][1])
        }

        val count = IntArray(n + 1)
        for(i in 1..n) {
            count[find(parent, i)]++
        }

        val sizes = count.filter { it > 0 }
        if(sizes.size == 2) {
            minAbs = min(minAbs, abs(sizes[0] - sizes[1]))
        }
    }

    return minAbs
}

fun main() {
    val n = 9
    val wires = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6),
        intArrayOf(4, 7),
        intArrayOf(7, 8),
        intArrayOf(7, 9)
    )

    println(solution(n, wires))
}
