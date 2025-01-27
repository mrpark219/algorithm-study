package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()
    var nums = br.readLine().split(" ").map { it.toInt() }
    val x = br.readLine().toInt()

    nums = nums.sorted()

    var start = 0
    var end = n - 1

    var count = 0
    while(start < end) {

        if(nums[start] + nums[end] == x) {
            count++
        }

        if(nums[start] + nums[end] > x) {
            end--
        }
        else {
            start++
        }
    }

    write("$count")
    close()
}