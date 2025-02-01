package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val map = Array(n) { CharArray(m) }

    for(i in 0 until n) {
        val list = br.readLine().toCharArray()
        for(j in 0 until m) {
            map[i][j] = list[j]
        }
    }

    var count = 0
    val direction = arrayOf(Pair(1, 0), Pair(-1, 0), Pair(0, 1), Pair(0, -1))

    for(i in 0 until n) {
        for(j in 0 until m) {
            var isSame = true

            for(z in 0 until 4) {
                val nextX = i + direction[z].first
                val nextY = j + direction[z].second

                // 범위 초과는 스킵
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue
                }

                if(map[i][j] != map[nextX][nextY]) {
                    isSame = false
                    break
                }
            }

            if(isSame) {
                count++
            }
        }
    }

    write("${pow(count)}")
    close()
}

private fun pow(num: Int): Long {
    if(num == 1) {
        return 2
    }
    val temp: Long
    if(num % 2 == 0) {
        temp = pow(num / 2)
        return (temp * temp) % 1000000007
    }
    else {
        temp = pow(num - 1)
        return (2 * temp) % 1000000007
    }
}