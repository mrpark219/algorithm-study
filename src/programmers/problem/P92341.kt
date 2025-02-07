package programmers.problem

private fun solution(fees: IntArray, records: Array<String>): IntArray {

    val inOutMap = mutableMapOf<String, String>()
    val cumulativeMap = mutableMapOf<String, Int>()

    for(record in records) {
        val (time, number, type) = record.split(" ").map { it }

        if(type == "IN") {
            inOutMap[number] = time
        }
        else {
            val inTime = inOutMap.remove(number) ?: continue
            val (inHour, inMinute) = inTime.split(":").map { it.toInt() }
            val (outHour, outMinute) = time.split(":").map { it.toInt() }

            val gap = (outHour * 60 + outMinute) - (inHour * 60 + inMinute)
            cumulativeMap[number] = cumulativeMap.getOrDefault(number, 0) + gap
        }
    }

    inOutMap.forEach { (number, inTime) ->
        val (inHour, inMinute) = inTime.split(":").map { it.toInt() }
        val (outHour, outMinute) = 23 to 59

        val gap = (outHour * 60 + outMinute) - (inHour * 60 + inMinute)
        cumulativeMap[number] = cumulativeMap.getOrDefault(number, 0) + gap
    }

    val cumulativeList = cumulativeMap.toList().sortedBy { it.first }

    return cumulativeList.map { (number, time) ->
        var price = fees[1]
        var restTime = time
        restTime -= fees[0]
        if(restTime > 0) {
            price += (restTime / fees[2]) * fees[3]
            if(restTime % fees[2] > 0) price += fees[3]
        }
        price
    }.toIntArray()
}

fun main() {

    val fees = intArrayOf(120, 0, 60, 591)
    val records = arrayOf(
        "16:00 3961 IN",
        "16:00 0202 IN",
        "18:00 3961 OUT",
        "18:00 0202 OUT",
        "23:58 3961 IN"
    )

    println(solution(fees, records).contentToString())
}

