package tasks4_divB

fun main() {
    val n = readLine()!!.toInt()

    val numberMessageToTopic = MutableList(n + 1) { 0 }
    val numberTopicToCountName: MutableMap<Int, Pair<Int, String>> = mutableMapOf()

    var maxCount = 1
    for (i in 1..n) {
        val numberInput = readLine()!!.toInt()

        if (numberInput == 0) {
            val topic = readLine()!!
            val message = readLine()!!

            numberMessageToTopic[i] = i
            numberTopicToCountName.put(i, Pair(1, topic))
        } else {
            val message = readLine()!!

            val numTopic = numberMessageToTopic[numberInput]
            numberMessageToTopic[i] = numTopic

            val getCountName = numberTopicToCountName[numTopic]!!
            if (getCountName.first + 1 > maxCount) maxCount = getCountName.first + 1

            numberTopicToCountName.put(numTopic, Pair(getCountName.first + 1, getCountName.second))
        }
    }

    for (topic in numberTopicToCountName.values) {
        if (topic.first == maxCount) {
            println(topic.second)
            break
        }
    }
}