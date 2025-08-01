package tasks3_divB

fun main() {
    val m = readLine()!!.toInt()
    val observerArray = mutableListOf<String>()

    repeat(m) {
        observerArray.add(readLine()!!)
    }

    val n = readLine()!!.toInt()
    val numbersArray = mutableListOf<Pair<String, Int>>()

    repeat(n) {
        numbersArray.add(Pair(readLine()!!, 0))
    }

    var maxValue = 0
    for (i in 0 until n) {
        var newValue = 0

        for (observer in observerArray) {
            var matched = true
            for (char in observer) {
                if (char !in numbersArray[i].first) {
                    matched = false
                    break
                }
            }

            if (matched) newValue++
        }

        numbersArray[i] = Pair(numbersArray[i].first, newValue)
        if (newValue > maxValue) {
            maxValue = newValue
        }
    }

    numbersArray.forEach { (key, value) ->
        if (value == maxValue) println(key)
    }
}