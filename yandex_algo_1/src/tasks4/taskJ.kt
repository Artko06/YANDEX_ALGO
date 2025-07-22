package tasks4

import java.io.BufferedReader
import java.io.InputStreamReader

fun isCorrectChar(c: Char): Boolean {
    return c.isDigit() || c.isLetter() || c == '_'
}

fun isCorrectForPut(
    identifier: String,
    isStartWithNumber: Boolean,
    isCaseMatter: Boolean,
    keyWords: Set<String>
): Boolean {
    if(!isStartWithNumber && identifier.first().isDigit()) return false
    if (!identifier.any { !it.isDigit() }) return false
    return if (isCaseMatter){
        identifier !in keyWords
    } else {
        identifier.lowercase() !in keyWords
    }
}

fun MutableMap<String, Pair<Int, Int>>.putByCase(identifier: String, position: Int, isCaseMatter: Boolean){
    if (isCaseMatter) {
        val getByIdentifier =
            this.getOrDefault(
                identifier,
                Pair(0, -1)
            )

        this[identifier] =
            Pair(
                first = getByIdentifier.first + 1,
                second = if(getByIdentifier.second == -1) position else getByIdentifier.second
            )
    } else {
        val getByIdentifier =
            this.getOrDefault(
                identifier.lowercase(),
                Pair(0, -1)
            )

        this[identifier.lowercase()] =
            Pair(
                first = getByIdentifier.first + 1,
                second = if(getByIdentifier.second == -1) position else getByIdentifier.second
            )
    }
}

fun MutableMap<String, Pair<Int, Int>>.getMostFrequency(): String {
    var mostFrequent = ""
    var mostFrequency = 0
    var position = -1

    this.forEach { (identifier, pair) ->
        if (mostFrequency < pair.first) {
            mostFrequent = identifier
            mostFrequency = pair.first
            position = pair.second
        }
        else if(mostFrequency == pair.first && position > pair.second) {
            mostFrequent = identifier
            mostFrequency = pair.first
            position = pair.second
        }
    }

    return mostFrequent
}

fun main() {
    val inputInfoLanguage = readLine()!!.split(" ")
    val amountKeyWords = inputInfoLanguage[0].toInt()
    val isCaseMatter = inputInfoLanguage[1].let { it == "yes" }
    val isStartWithNumber = inputInfoLanguage[2].let { it == "yes" }

    val keyWords: MutableSet<String> = mutableSetOf()
    repeat(amountKeyWords) {
        val keyWord = if(!isCaseMatter) readLine()!!.lowercase() else readLine()!!
        keyWords.add(keyWord)
    }

    val code = BufferedReader(InputStreamReader(System.`in`)).lineSequence()

    val dictionaryIdentifiers = mutableMapOf<String, Pair<Int, Int>>()
    var position = 0
    code.forEach { line ->
        val trimLine = line.trim()
        val sizeTrimLine = trimLine.length

        val identifier = StringBuilder()
        for(i in 0 until sizeTrimLine) {
            if (isCorrectChar(
                    trimLine[i]
            )) {
                identifier.append(trimLine[i])

                if (i + 1 == sizeTrimLine && identifier.isNotEmpty()) {
                    if (isCorrectForPut(
                            identifier = identifier.toString(),
                            isStartWithNumber = isStartWithNumber,
                            isCaseMatter = isCaseMatter,
                            keyWords = keyWords
                    )) {
                        dictionaryIdentifiers.putByCase(
                            identifier = identifier.toString(),
                            position = position++,
                            isCaseMatter = isCaseMatter)
                    }

                    identifier.clear()
                }
            } else if(identifier.isNotEmpty()) {
                if (isCorrectForPut(
                        identifier = identifier.toString(),
                        isStartWithNumber = isStartWithNumber,
                        isCaseMatter = isCaseMatter,
                        keyWords = keyWords
                    )) {
                    dictionaryIdentifiers.putByCase(
                        identifier = identifier.toString(),
                        position = position++,
                        isCaseMatter = isCaseMatter)
                }

                identifier.clear()
            }
        }
    }

    println(dictionaryIdentifiers.getMostFrequency())
}