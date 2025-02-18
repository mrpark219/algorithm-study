package programmers.problem

private val words = mutableListOf<String>()
private val vowels = arrayOf("A", "E", "I", "O", "U")

private fun solution(word: String): Int {

    dfs("")

    return words.indexOf(word)
}

private fun dfs(word: String) {

    if(word.length > 5) {
        return
    }

    words.add(word)
    for(vowel in vowels) {
        dfs(word + vowel)
    }
}

fun main() {

    val word = "AAAAE"

    println(solution(word))
}

