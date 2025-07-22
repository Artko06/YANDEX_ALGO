package tasks2

fun getEmptyFieldWithFake(line: Int, column: Int): MutableList<MutableList<String>> {
    return MutableList(column + 2){MutableList(line + 2) {"0"} }
}

fun getBombField(emptyField: MutableList<MutableList<String>>, bombs: List<Pair<Int, Int>>): MutableList<MutableList<String>> {
    val bombField = emptyField

    for (i in bombs.indices) {
        bombField[bombs[i].first][bombs[i].second] = "*"
    }

    return bombField
}

fun getNumberBombField(bombField: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    val numberBombField = bombField

    for (i in 1 until numberBombField.size - 1) {
        for (j in 1 until numberBombField[0].size - 1) {
            if (numberBombField[i][j] == "*") continue

            val viewCells = listOf(numberBombField[i - 1][j - 1], numberBombField[i][j - 1], numberBombField[i + 1][j - 1],
                numberBombField[i - 1][j], numberBombField[i + 1][j],
                numberBombField[i - 1][j + 1], numberBombField[i][j + 1], numberBombField[i + 1][j + 1]
            )
            val countBomb = viewCells.count { it == "*" }

            numberBombField[i][j] = countBomb.toString()
        }
    }

    return numberBombField
}

fun main(){
    val inputLine1 = readLine()!!.trim().split(" ").map { it.toInt() }
    val column = inputLine1[0]
    val line = inputLine1[1]
    val numbersBomb = inputLine1[2]
    val bombs: MutableList<Pair<Int, Int>> = mutableListOf()

    for(i in 1..numbersBomb){
        val placeBomb = readLine()!!.trim().split(" ").map { it.toInt() }

        bombs.add(Pair(placeBomb[0],placeBomb[1]))
    }

    val emptyField: MutableList<MutableList<String>> = getEmptyFieldWithFake(line, column)
    val bombField = getBombField(emptyField, bombs)
    val numberBombField = getNumberBombField(bombField)

    for (i in 1 until numberBombField.size - 1){
        for (j in 1 until numberBombField[0].size - 1){
            print(numberBombField[i][j] + " ")
        }
        print("\n")
    }
}