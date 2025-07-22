package tasks4

import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val dictionary = mutableMapOf<String, Int>()

    BufferedReader(InputStreamReader(System.`in`))
        .lineSequence()
        .forEach { line ->
            line
                .trim()
                .split("\\s+".toRegex())
                .filter { it.isNotBlank() }
                .forEach {
                    dictionary[it] = dictionary.getOrDefault(it, 0) + 1
                }
    }

    var maxFrequencyWord = ""
    var maxFrequency = -1
    dictionary.forEach { (word, frequency) ->
        when{
            frequency > maxFrequency -> {
                maxFrequency = frequency
                maxFrequencyWord = word
            }
            frequency == maxFrequency && word < maxFrequencyWord -> {
                maxFrequencyWord = word
            }
        }
    }

    println(maxFrequencyWord)
}