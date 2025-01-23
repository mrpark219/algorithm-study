package baekjoon.problem

import java.util.*

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (n, w, l) = br.readLine().split(" ").map { it.toInt() }

    val truckArray = br.readLine().split(" ").map { it.toInt() }

    var time = 0
    val bridgeQueue: Queue<Int> = LinkedList(List(w) { 0 })
    val waitingQueue: Queue<Int> = LinkedList(truckArray)

    while(bridgeQueue.isNotEmpty()) {
        time++
        bridgeQueue.poll()
        if(waitingQueue.isNotEmpty()) {
            if(bridgeQueue.sum() + waitingQueue.peek() <= l) {
                bridgeQueue.add(waitingQueue.poll())
            }
            else {
                bridgeQueue.add(0)
            }
        }
    }

    write("$time")
    close()
}