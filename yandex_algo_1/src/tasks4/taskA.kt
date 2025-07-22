package tasks4

fun main(){
    val size = readLine()!!.toInt()
    val dictionary = mutableMapOf<String, String>()

    repeat(size){
        val (word1, word2) = readLine()!!.split(" ")

        dictionary.put(word1, word2)
        dictionary.put(word2, word1)
    }

    println(dictionary[readLine()!!])
}