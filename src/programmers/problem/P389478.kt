package programmers.problem

class Solution {
    fun solution(n: Int, w: Int, num: Int): Int {

        val targetRow = (num - 1) / w
        val targetCol = if(targetRow % 2 == 0) (num - 1) % w else w - 1 - (num - 1) % w

        val nRow = (n - 1) / w
        val nCol = if(nRow % 2 == 0) (n - 1) % w else w - 1 - (n - 1) % w

        val max = if(nRow % 2 == 0) {
            if(targetCol > nCol) {
                nRow
            }
            else {
                nRow + 1
            }
        }
        else {
            if(targetCol >= nCol) {
                nRow + 1
            }
            else {
                nRow
            }
        }

        return max - targetRow
    }
}

fun main() {
    val n = 22
    val w = 6
    val num = 8

    println(Solution().solution(n, w, num))
}
