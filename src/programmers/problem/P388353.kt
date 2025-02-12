package programmers.problem

import java.util.*

private fun solution(storage: Array<String>, requests: Array<String>): Int {

    val n = storage.size
    val m = storage[0].length
    val storages = Array(n) { Array(m) { "" } }
    for(i in 0 until n) {
        for(j in 0 until m) {
            storages[i][j] = storage[i][j].toString()
        }
    }

    val directions = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    val alphabets = ('A'..'Z').map { it.toString() }
    var index = 0
    for(request in requests) {

        index++
        val target = request[0].toString()

        for(i in 0 until n) {
            for(j in 0 until m) {
                val value = storages[i][j]

                // 다르면 다음꺼
                if(target != value) {
                    continue
                }

                // 지게차
                if(request.length == 1) {

                    val visit = Array(n) { BooleanArray(m) }
                    val queue = LinkedList<Pair<Int, Int>>()

                    queue.add(Pair(i, j))
                    visit[i][j] = true
                    var isOk = false
                    var isOut = false

                    while(queue.isNotEmpty()) {
                        val current = queue.poll()

                        for(k in 0..3) {
                            val nextI = current.first + directions[k].first
                            val nextJ = current.second + directions[k].second

                            // 밖과 연결됨
                            if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= m) {
                                isOk = true
                                isOut = true
                                break
                            }

                            if((storages[nextI][nextJ] != index.toString()
                                        && storages[nextI][nextJ] !in alphabets) && !visit[nextI][nextJ]
                            ) {
                                visit[nextI][nextJ] = true
                                queue.add(Pair(nextI, nextJ))
                            }
                        }

                        if(isOut) {
                            break
                        }
                    }

                    if(isOk) {
                        storages[i][j] = index.toString()
                    }
                }
                // 크레인
                else {
                    storages[i][j] = index.toString()
                }
            }
        }
    }

    var count = 0
    for(i in 0 until n) {
        for(j in 0 until m) {
            if(storages[i][j] in alphabets) {
                count++
            }
        }
    }

    return count
}

fun main() {

    val storage = arrayOf("AZWQY", "CAABX", "BBDDA", "ACACA")
    val requests = arrayOf("A", "BB", "A")

    println(solution(storage, requests))
}