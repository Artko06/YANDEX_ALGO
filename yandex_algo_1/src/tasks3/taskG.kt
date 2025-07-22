package tasks3

fun main(){
    val size = readLine()!!.toInt()
    val voiceTortoises: List<Pair<Int, Int>> = List(size) {
        val voice = readLine()!!.split(" ")

        voice[0].toInt() to voice[1].toInt()
    }

    val uniqueVoices = mutableSetOf<Int>()

    voiceTortoises.forEach {
        if (it.first >= 0 && it.first <= size - 1 && it.second >= 0 && it.second <= size) {
            if (it.first + it.second == size - 1 && it.first + 1 !in uniqueVoices){
                uniqueVoices.add(it.first + 1)
            }
        }
    }

    println(uniqueVoices.size)
}