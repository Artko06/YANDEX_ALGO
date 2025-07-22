package tasks3

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val words = mutableSetOf<String>()

    while (scanner.hasNext()) {
        val line = scanner.nextLine()
        if (line.isBlank()) continue
        val splitWords = line.trim().split("\\s+".toRegex())
        words.addAll(splitWords)
    }

    println(words.size)
}