package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    var n = br.readLine().toInt()

    // (100+1+ | 01)+
    val pattern = Regex("(100+1+|01)+")

    while(n-- > 0) {

        val input = br.readLine()

        if(pattern.matches(input)) {
            write("YES\n")
        }
        else {
            write("NO\n")
        }
    }

    close()
}