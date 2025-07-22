package tasks4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val repeatedWords = mutableMapOf<String, Int>()
    val output = StringBuilder()

    reader.lineSequence().forEach { line ->
        line.trim().split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .forEach { word ->
                val count = repeatedWords.getOrDefault(word, 0)

                output.append("$count ")

                repeatedWords[word] = count + 1
            }
    }

    print(output.toString())
}