package tasks3

fun main(){
    val amountPupils = readLine()!!.toInt()

    val listLanguages: List<Set<String>> = List(amountPupils) {
        val amountLanguages = readLine()!!.toInt()

        List(amountLanguages) {
            readLine()!!
        }.toSet()
    }

    var intersectionSets: Set<String> = listLanguages[0]
    var unionSets: Set<String> = listLanguages[0]
    for (i in 1 until listLanguages.size){
        intersectionSets = intersectionSets.intersect(listLanguages[i])
        unionSets = unionSets.union(listLanguages[i])
    }

    println(intersectionSets.size)
    intersectionSets.forEach{ println(it) }

    println(unionSets.size)
    unionSets.forEach{ println(it) }
}