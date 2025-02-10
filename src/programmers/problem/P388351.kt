package programmers.problem

private fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {

    val workers = BooleanArray(schedules.size) { true }

    for(i in 0..6) {

        var day = (startday + i) % 7
        if(day == 0) {
            day = 7
        }

        // 주말
        if(day == 6 || day == 7) {
            continue
        }

        for(j in schedules.indices) {

            if(!workers[j]) {
                continue
            }

            val scheduleHour = schedules[j] / 100
            val scheduleMinute = schedules[j] % 100

            // 이 시간 전까지
            val scheduleTime = scheduleHour * 60 + scheduleMinute + 10

            val realHour = timelogs[j][i] / 100
            val realMinute = timelogs[j][i] % 100

            val realTime = realHour * 60 + realMinute

            if(realTime > scheduleTime) {
                workers[j] = false
            }
        }
    }

    return workers.count { it }
}

fun main() {

    val schedules = intArrayOf(700, 800, 1100)
    val timelogs = arrayOf(
        intArrayOf(710, 2359, 1050, 700, 650, 631, 659),
        intArrayOf(800, 801, 805, 800, 759, 810, 809),
        intArrayOf(1105, 1001, 1002, 600, 1059, 1001, 1100)
    )
    val startday = 5

    println(solution(schedules, timelogs, startday))
}