package tasks4_divB

fun main() {
    val frequencyWords = mutableMapOf<String, Int>()

    val reader = System.`in`.bufferedReader()
    reader.lineSequence().forEach { line ->
        val words = line.trim().split(" ")

        words.forEach { word ->
            val getFrequencyWords = frequencyWords.getOrDefault(word, 0)

            frequencyWords[word] = getFrequencyWords + 1
        }
    }

    frequencyWords.toList().sortedWith(
        comparator = compareByDescending<Pair<String, Int>> { it.second }.thenBy{it.first}
    ).forEach { (word, frequency) ->
        println(word)
    }
}