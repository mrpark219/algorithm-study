package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    var valid = 0L
    var total = combination(n, m)
    for(i in k..m) {
        if(n - m < m - i) {
            continue
        }
        valid += combination(m, i) * combination(n - m, m - i)
    }

    write("${valid / total.toDouble()}\n")
    close()
}

private fun combination(a: Int, b: Int): Long {
    var n = a
    var r = b
    var nn = 1L
    var rr = 1L

    while(r > 0) {
        nn *= n--
        rr *= r--
    }

    return nn / rr
}