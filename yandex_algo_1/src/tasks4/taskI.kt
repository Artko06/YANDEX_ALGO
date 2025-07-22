package tasks4

fun countStress(word: String): Int {
    var counterStress = 0

    for(c in word) {
        if(c in 'A'..'Z') counterStress++
    }

    return counterStress
}

fun main() {
    val n = readLine()!!.toInt()
    val dictionaryWords = mutableMapOf<String, MutableSet<String>>()
    var countMistakes = 0

    repeat(n){
        val word = readLine()!!
        val lowerWord = word.lowercase()

        val setByWord = dictionaryWords.getOrDefault(lowerWord, mutableSetOf())
        setByWord.add(word)

        dictionaryWords[lowerWord] = setByWord
    }

    val analysisWords = readLine()!!.split(" ").filter { it.isNotBlank() }

    analysisWords.forEach { word ->
        val lowerWord = word.lowercase()
        val dictionaryWord = dictionaryWords[lowerWord]

        when{
            dictionaryWord != null -> {
                if (word !in dictionaryWord) countMistakes++
            }
            else -> {
                if (countStress(word) != 1) countMistakes++
            }
        }
    }

    println(countMistakes)
}