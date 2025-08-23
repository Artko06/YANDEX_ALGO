package razminka

fun placeBehindPetya(generalPlace: Int, totalVariants: Int, n: Int): Pair<Int, Int> {
    if (generalPlace + totalVariants > n) return Pair(-1, -1)
    val generalPlaceBehindPetya = generalPlace + totalVariants

    return Pair((generalPlaceBehindPetya + 1) / 2, if (generalPlaceBehindPetya % 2 == 0) 2 else 1)
}

fun placeInFrontOfPetya(generalPlace: Int, totalVariants: Int): Pair<Int, Int> {
    if (generalPlace - totalVariants <= 0) return Pair(-1, -1)
    val generalPlaceBehindPetya = generalPlace - totalVariants

    return Pair((generalPlaceBehindPetya + 1) / 2, if (generalPlaceBehindPetya % 2 == 0) 2 else 1)
}

fun main() {
    val n = readln().toInt()
    val k = readln().toInt()

    val rowPetya = readln().toInt()
    val columnPetya = readln().toInt() // 1 or 2

    val generalPlace = if (columnPetya == 1) (rowPetya * 2 - 1) else rowPetya * 2

    val placeBehindPetya = placeBehindPetya(generalPlace, k, n)
    val placeInFrontOfPetya = placeInFrontOfPetya(generalPlace, k)
    val betweenBehindRows = placeBehindPetya.first - rowPetya
    val betweenInFrontOfRows = rowPetya - placeInFrontOfPetya.first

    if (placeBehindPetya.first != -1 && (betweenBehindRows <= betweenInFrontOfRows || placeInFrontOfPetya.first == -1)) {
        println("${placeBehindPetya.first} ${placeBehindPetya.second}")
    } else if(placeInFrontOfPetya.first != -1) {
        println("${placeInFrontOfPetya.first} ${placeInFrontOfPetya.second}")
    } else {
        println(-1)
    }
}