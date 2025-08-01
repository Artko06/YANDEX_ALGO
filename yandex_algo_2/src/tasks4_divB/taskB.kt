package tasks4_divB

fun main() {
    val voices = mutableMapOf<String, Int>()

    val reader = System.`in`.bufferedReader()
    reader.lineSequence().forEach { line ->
        val (name, countVoices) = line.split(" ")

        val getVoices = voices.getOrDefault(name, 0)
        voices[name] = countVoices.toInt() + getVoices
    }

    voices.toSortedMap().forEach { (name, count) ->
        println("$name $count")
    }
}