package baekjoon.problem

fun main() = with(System.out.bufferedWriter()) {
    val br = System.`in`.bufferedReader()
    val html = br.readLine()

    val titlePattern = Regex("""<div\s+title="(.*?)">(.*?)</div>""")
    val paragraphPattern = Regex("""<p>(.*?)</p>""")

    val titleMatches = titlePattern.findAll(html)
    var isFirst = true

    for(titleMatch in titleMatches) {
        if(!isFirst) {
            write("\n")
        }
        isFirst = false

        val title = titleMatch.groupValues[1]
        val paragraphHtml = titleMatch.groupValues[2]

        write("title : $title")

        val paragraphs = paragraphPattern.findAll(paragraphHtml)
        for(paragraph in paragraphs) {
            val text = paragraph.groupValues[1]
                .replace(Regex("<.*?>"), "")
                .replace(Regex("\\s+"), " ")
                .trim()
            write("\n$text")
        }
    }

    close()
}
