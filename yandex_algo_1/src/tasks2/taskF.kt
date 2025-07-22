package tasks2

fun makeSymmetric(sequence: List<Int>): Pair<Int, List<Int>> {
    val n = sequence.size
    // Проверяем, является ли последовательность уже симметричной
    if (sequence == sequence.reversed()) {
        return Pair(0, emptyList())
    }

    // Ищем минимальное i, начиная с которого seq[i..n-1] — палиндром
    for (i in 1 until n) {
        val suffix = sequence.subList(i, n)
        if (suffix == suffix.reversed()) {
            // Нужно дописать sequence[0..i-1] в обратном порядке
            val m = i
            val toAppend = sequence.subList(0, i).reversed()
            return Pair(m, toAppend)
        }
    }

    // Если не нашли, дописываем всю последовательность, кроме последнего элемента
    return Pair(n - 1, sequence.subList(0, n - 1).reversed())
}

fun main() {
    val n = readLine()!!.toInt()
    val sequence = readLine()!!.trim().split(' ').map { it.toInt() }
    val (m, toAppend) = makeSymmetric(sequence)
    println(m)
    if (m > 0) {
        println(toAppend.joinToString(" "))
    }
}