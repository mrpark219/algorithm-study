package baekjoon.problem

lateinit var passwordArray: CharArray
lateinit var alphabetList: List<Char>
val resultSet = sortedSetOf<String>()

fun main() = with(System.out.bufferedWriter()) {

    val br = System.`in`.bufferedReader()

    val (l, c) = br.readLine().split(" ").map { it.toInt() }

    alphabetList = br.readLine().split(" ").map { it[0] }.sorted()

    passwordArray = CharArray(l)

    dfs(l, 0, 0)

    resultSet.forEach { write("$it\n") }

    close()
}

fun dfs(l: Int, count: Int, index: Int) {

    if(count == l) {
        val password = String(passwordArray)
        if(isValidCombination(password)) {
            resultSet.add(password)
        }
        return
    }

    for(i in index until alphabetList.size) {
        passwordArray[count] = (alphabetList[i])
        dfs(l, count + 1, i + 1)
    }
}

fun isValidCombination(password: String): Boolean {
    var vowelsCount = 0

    for(c in password) {
        if(isVowel(c)) {
            vowelsCount++
        }
    }
    val consonantsCount = password.length - vowelsCount

    return vowelsCount >= 1 && consonantsCount >= 2
}

fun isVowel(c: Char): Boolean {
    return c in "aeiou"
}
