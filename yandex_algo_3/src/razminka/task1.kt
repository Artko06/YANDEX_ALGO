package razminka

fun main() {
    val frequencyChars = sortedMapOf<Char, Int>()
    val reader = System.`in`.bufferedReader()

    var maxFrequency = 0
    reader.lineSequence().forEach { line ->
        line.forEach { char ->
            if (char != '\n' && char != ' ') {
                val newFrequency = frequencyChars.getOrDefault(char, 0) + 1
                frequencyChars[char] = newFrequency

                if (newFrequency > maxFrequency) maxFrequency = newFrequency
            }
        }
    }

    val answer = StringBuilder()
    for(i in maxFrequency downTo 1) {
        for(frequency in frequencyChars.values) {
            if (frequency >= i) answer.append('#')
            else answer.append(' ')
        }
        answer.append('\n')
    }

    for (char in frequencyChars.keys) {
        answer.append(char)
    }

    println(answer)
}