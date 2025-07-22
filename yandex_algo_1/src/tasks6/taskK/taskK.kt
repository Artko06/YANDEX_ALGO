package tasks6.taskK

import kotlin.math.max
import kotlin.math.min

fun genSequence(x1: Int, d1: Int, a: Int, c: Int, m: Int, size: Int): List<Int> {
    val seq = mutableListOf<Int>()

    var x = x1
    var d = d1
    repeat(size) {
        seq.add(x)
        x = x + d
        d = (a * d + c) % m
    }

    return seq
}


fun lBinSearch(seq1: List<Int>, target: Int): Int {
    var left = 0
    var right = seq1.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        if (seq1[mid] < target) {
            left = mid + 1
        } else right = mid
    }

    return left
}

fun countLess(seq: List<Int>, target: Int): Int {
    val countLess = lBinSearch(seq, target)

    return if (seq[countLess] < target) seq.size
    else countLess
}


fun medianSequences(seq1: List<Int>, seq2: List<Int>): Int {
    var left = min(seq1[0], seq2[0])
    var right = max(seq1.last(), seq2.last())

    while (left < right) {
        val mid = (left + right + 1) / 2

        val countLess = countLess(seq1, mid) + countLess(seq2, mid)
        if (countLess < seq1.size) {
            left = mid
        } else {
            right = mid - 1
        }
    }

    return left
}


fun main() {
    val (n, l) = readLine()!!.split(" ").map { it.toInt() }
    val sequences = List(n) {
        val input = readLine()!!.split(" ").map { it.toInt() }

        genSequence(input[0], input[1], input[2], input[3], input[4], l)
    }

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            println(medianSequences(sequences[i], sequences[j]))
        }
    }
}

// to do pypy