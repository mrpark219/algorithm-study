package baekjoon.problem

private lateinit var visited: IntArray
private lateinit var clear: BooleanArray
private lateinit var connectionInfo: Array<MutableList<Int>>

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    visited = IntArray(m + 1)
    clear = BooleanArray(m + 1)
    connectionInfo = Array(n + 1) { mutableListOf() }

    for(i in 1..n) {
        val input = br.readLine().split(" ").map { it.toInt() }

        for(j in 1 until input.size) {
            connectionInfo[i].add(input[j])
        }
    }

    var count = 0
    for(i in 1..n) {
        clear.fill(false)
        if(dfs(i)) {
            count++
            if(count == m) {
                break
            }
        }
    }

    write("$count")
    close()
}

private fun dfs(n: Int): Boolean {

    for(i in connectionInfo[n]) {
        if(clear[i]) {
            continue
        }
        clear[i] = true

        if(visited[i] == 0 || dfs(visited[i])) {
            visited[i] = n
            return true
        }
    }

    return false
}