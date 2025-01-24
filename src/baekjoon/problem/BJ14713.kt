package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    val parrots = Array<Queue<String>>(n) { LinkedList() }

    for(i in 0 until n) {
        val input = br.readLine().split(" ").map { it }
        parrots[i].addAll(input)
    }

    val sentence = br.readLine().split(" ")
    val words = LinkedList(sentence)
    var result = true

    while(words.isNotEmpty()) {

        val now = words.poll()

        var possible = false
        for(i in 0 until n) {
            if(now == parrots[i].peek()) {
                parrots[i].poll()
                possible = true
                break
            }
        }

        if(!possible) {
            result = false
            break
        }
    }

    if(result) {
        for(parrot in parrots) {
            if(parrot.isNotEmpty()) {
                result = false
                break
            }
        }
    }

    write(if(result) "Possible" else "Impossible")
    close()
}