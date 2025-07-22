package tasks4

fun main(){
    val n = readLine()!!.toInt()
    val dictionaryBlocks = mutableMapOf<Int, Int>()

    repeat(n){
        val (w, h) = readLine()!!.split(" ").map { it.toInt() }
        val hInDictionary = dictionaryBlocks.getOrDefault(w, 0)

        if (h > hInDictionary){
            dictionaryBlocks[w] = h
        }
    }

    var maxH = 0L
    dictionaryBlocks.forEach { (_, h) ->
        maxH += h
    }

    println(maxH)
}