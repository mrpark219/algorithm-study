package baekjoon.problem

private lateinit var clear: BooleanArray
private lateinit var visited: IntArray
private lateinit var connectionInfo: Array<MutableList<Int>>


fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    clear = BooleanArray(m + 1)
    visited = IntArray(m + 1)
    connectionInfo = Array(n + 1) { mutableListOf() }

    for(i in 1..n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for(j in 1 until line.size) {
            connectionInfo[i].add(line[j])
        }
    }

    var count = 0
    for(i in 1..n) {
        // 매칭을 할 때마다 모든 노드를 처리되지 않은 상태로 변경
        clear.fill(false)
        if(dfs(i)) {
            count++

            // m개의 일을 모두 수행할 수 있는 경우 탐색 종료
            if(count == m) {
                break
            }
        }
    }

    write("$count")
    close()
}

// 매칭에 성공한 경우 true, 실패한 경우 false
private fun dfs(n: Int): Boolean {

    // 연결된 모든 노드에 대해서 들어갈 수 있는지 확인
    for(i in connectionInfo[n]) {
        // 이미 처리한 노드는 더 이상 볼 필요가 없음
        if(clear[i]) {
            continue
        }
        clear[i] = true

        // 연결할 노드가 비어있거나, 다른 노드와 연결할 수 있는 경우
        if(visited[i] == 0 || dfs(visited[i])) {
            visited[i] = n
            return true
        }
    }

    return false
}