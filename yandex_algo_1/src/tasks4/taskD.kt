package tasks4

fun main(){
    val amountButton = readLine()!!.toInt()
    val amountMaxTapsEachButton = mutableMapOf<Int, Int>()

    val inputKeys = readLine()!!.trim().split(" ").map { it.toInt() }

    for(i in 0 until amountButton){
        amountMaxTapsEachButton[i + 1] = inputKeys[i]
    }

    val amountTaps = readLine()!!.toInt()
    val tapsEachButton = readLine()!!.trim().split(" ").map { it.toInt() }

    for (i in 0 until amountTaps) {
        val numberButton = tapsEachButton[i]

        amountMaxTapsEachButton[numberButton] = amountMaxTapsEachButton[numberButton]!! - 1
    }

    amountMaxTapsEachButton.forEach {(_, taps) ->
        if (taps < 0) println("YES")
        else println("NO")
    }
}