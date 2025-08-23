package razminka

fun main() {
    val str = readln()
    val dictionaryLetters = sortedMapOf<Char, Long>()

    for (i in str.indices) {
        val char = str[i]

        dictionaryLetters[char] = dictionaryLetters.getOrDefault(char, 0) + (i + 1) * (str.length - i).toLong()
    }

    dictionaryLetters.forEach { (char, numbers) ->
        println("$char: $numbers")
    }
}