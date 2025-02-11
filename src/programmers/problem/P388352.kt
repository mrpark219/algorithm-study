package programmers.problem

private fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {

    // 1부터 n까지의 숫자 중에서 5개를 고르는 모든 조합 생성
    val numbers = (1..n).toList()
    val allCombinations = numbers.combinations(5)

    // 가능한 비밀 코드의 개수
    var validCount = 0

    // 각 조합에 대해 시도와 응답을 만족하는지 확인
    for(combination in allCombinations) {
        var isValid = true
        for(i in q.indices) {
            val guess = q[i]
            val correctCount = ans[i]
            val commonCount = combination.count { it in guess }
            if(commonCount != correctCount) {
                isValid = false
                break
            }
        }
        if(isValid) {
            validCount++
        }
    }

    return validCount
}

private fun List<Int>.combinations(k: Int): List<List<Int>> {

    // 0이면 빈 List
    if(k == 0) {
        return listOf(emptyList())
    }

    // K 길이면 남은 리스트들
    if(k == this.size) {
        return listOf(this)
    }

    val result = mutableListOf<List<Int>>()
    for(i in this.indices) {
        val head = this[i]
        val tail = this.drop(i + 1)
        for(tailCombination in tail.combinations(k - 1)) {
            result.add(listOf(head) + tailCombination)
        }
    }

    return result
}

fun main() {

    val n = 10
    val q = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(3, 7, 8, 9, 10),
        intArrayOf(2, 5, 7, 9, 10),
        intArrayOf(3, 4, 5, 6, 7)
    )
    val ans = intArrayOf(2, 3, 4, 3, 3)

    println(solution(n, q, ans))
}